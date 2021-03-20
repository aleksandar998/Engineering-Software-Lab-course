package it.engineering.spring.mvc.ds.converter.impl;

import it.engineering.spring.mvc.ds.converter.ConverterDtoEntity;
import it.engineering.spring.mvc.ds.dto.ContactPersonDto;
import it.engineering.spring.mvc.ds.entity.ContactPersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactPersonConvertDtoEntity implements ConverterDtoEntity<ContactPersonDto, ContactPersonEntity> {

    private ManufacturerConverterDtoEntity manufacturerConverterDtoEntity;

    @Autowired
    public ContactPersonConvertDtoEntity(ManufacturerConverterDtoEntity manufacturerConverterDtoEntity) {
        this.manufacturerConverterDtoEntity = manufacturerConverterDtoEntity;
    }

    @Override
    public ContactPersonDto toDto(ContactPersonEntity contactPersonEntity) {
        return new ContactPersonDto(contactPersonEntity.getId(),
                contactPersonEntity.getFirstname(),
                contactPersonEntity.getLastname(),
                manufacturerConverterDtoEntity.toDto(contactPersonEntity.getManufacturerEntity()));
    }

    @Override
    public ContactPersonEntity toEntity(ContactPersonDto dto) {
        return new ContactPersonEntity(dto.getId(),
                dto.getFirstname(),
                dto.getLastname(),
                manufacturerConverterDtoEntity.toEntity(dto.getManufacturerDto()));
    }
}
