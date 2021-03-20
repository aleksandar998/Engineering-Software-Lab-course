package it.engineering.spring.mvc.ds.validator;

import it.engineering.spring.mvc.ds.dto.ContactPersonDto;
import it.engineering.spring.mvc.ds.dto.ManufacturerDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContactPersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ContactPersonDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("Pozvana metoda validate u ContactPersonValidator klasi...");
        ContactPersonDto contactPersonDto = (ContactPersonDto) target;
        if (contactPersonDto!=null) {
            if (contactPersonDto.getFirstname().isEmpty()) {
                errors.rejectValue("firstname", "contactPerson.firstname", "Ime je obavezno polje.");
            }
            if (contactPersonDto.getLastname().isEmpty()) {
                errors.rejectValue("lastname", "contactPerson.lastname", "Prezime je obavezno polje.");
            }
            if(contactPersonDto.getManufacturerDto()==null) {
                errors.rejectValue("manufacturerDto",
                        "contactPerson.manufacturer", "Proizvodjac je obavezno polje.");
            }
        }
    }
}
