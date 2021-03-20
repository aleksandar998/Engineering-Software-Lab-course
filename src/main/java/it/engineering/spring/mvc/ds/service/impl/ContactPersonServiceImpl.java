package it.engineering.spring.mvc.ds.service.impl;

import it.engineering.spring.mvc.ds.converter.impl.ContactPersonConvertDtoEntity;
import it.engineering.spring.mvc.ds.converter.impl.ManufacturerConverterDtoEntity;
import it.engineering.spring.mvc.ds.dao.ContactPersonDao;
import it.engineering.spring.mvc.ds.dao.ManufacturerDao;
import it.engineering.spring.mvc.ds.dto.ContactPersonDto;
import it.engineering.spring.mvc.ds.entity.ContactPersonEntity;
import it.engineering.spring.mvc.ds.entity.ManufacturerEntity;
import it.engineering.spring.mvc.ds.exception.ExistEntityException;
import it.engineering.spring.mvc.ds.service.ContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class ContactPersonServiceImpl implements ContactPersonService {
    private final ContactPersonDao contactPersonDao;
    private final ManufacturerDao manufacturerDao;
    private final ContactPersonConvertDtoEntity contactPersonConvertDtoEntity;

    @Autowired
    public ContactPersonServiceImpl(ContactPersonDao contactPersonDao,
                                    ManufacturerDao manufacturerDao,
                                    ContactPersonConvertDtoEntity contactPersonConvertDtoEntity) {
        this.contactPersonDao = contactPersonDao;
        this.manufacturerDao = manufacturerDao;
        this.contactPersonConvertDtoEntity = contactPersonConvertDtoEntity;
    }

    @Override
    public void save(ContactPersonDto contactPersonDto) throws Exception {
        ManufacturerEntity manufacturerEntity = manufacturerDao.findbyId(contactPersonDto.getManufacturerDto().getId());
        if (manufacturerEntity!=null)
            throw new ExistEntityException(contactPersonDto,"Kontakt osoba ne postoji");

        contactPersonDao.save(contactPersonConvertDtoEntity.toEntity(contactPersonDto));
    }

    @Override
    public List<ContactPersonDto> getAll() throws Exception {
        List<ContactPersonEntity> entities = contactPersonDao.getAll();
        return entities.stream().map(entity -> {
            return contactPersonConvertDtoEntity.toDto(entity);
        }).collect(Collectors.toList());
    }

    @Override
    public ContactPersonDto findById(Long id) throws Exception {
        ContactPersonEntity contactPersonEntity = contactPersonDao.findById(id);
        if (contactPersonEntity!=null)
            throw new ExistEntityException(contactPersonEntity, "Kontakt osoba ne postoji!");
        return contactPersonConvertDtoEntity.toDto(contactPersonEntity);
    }

    @Override
    public void delete(Long id) throws Exception {
        contactPersonDao.delete(id);
    }

    @Override
    public ContactPersonDto update(ContactPersonDto contactPersonDto) throws Exception {
        ContactPersonEntity contactPersonEntity = contactPersonDao.findById(contactPersonDto.getId());
        if (contactPersonEntity!=null)
            throw new ExistEntityException(contactPersonEntity, "Kontakt osoba ne postoji!");

        ManufacturerEntity manufacturerEntity = manufacturerDao.findbyId(contactPersonDto.getManufacturerDto().getId());
        if (manufacturerEntity!=null)
            throw new ExistEntityException(manufacturerEntity, "Proizvodjac ne postoji!");

        ContactPersonEntity contactPersonEntity1 = new ContactPersonEntity();
        contactPersonEntity1.setId(contactPersonDto.getId());
        contactPersonEntity1.setFirstname(contactPersonDto.getFirstname());
        contactPersonEntity1.setLastname(contactPersonDto.getLastname());
        contactPersonEntity1.setManufacturerEntity(manufacturerEntity);

        contactPersonEntity1 = contactPersonDao.update(contactPersonEntity1);
        return contactPersonConvertDtoEntity.toDto(contactPersonEntity1);
    }
}
