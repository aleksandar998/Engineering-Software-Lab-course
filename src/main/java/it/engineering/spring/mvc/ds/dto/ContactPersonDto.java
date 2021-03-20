package it.engineering.spring.mvc.ds.dto;

import it.engineering.spring.mvc.ds.dao.Dto;

public class ContactPersonDto implements Dto {
    private Long id;
    private String firstname;
    private String lastname;
    private ManufacturerDto manufacturerDto;

    public ContactPersonDto(Long id, String firstname, String lastname, ManufacturerDto manufacturerDto) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.manufacturerDto = manufacturerDto;
    }

    public ContactPersonDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public ManufacturerDto getManufacturerDto() {
        return manufacturerDto;
    }

    public void setManufacturerDto(ManufacturerDto manufacturerDto) {
        this.manufacturerDto = manufacturerDto;
    }

    @Override
    public String toString() {
        return "ContactPersonDto{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", manufacturerDto=" + manufacturerDto +
                '}';
    }
}
