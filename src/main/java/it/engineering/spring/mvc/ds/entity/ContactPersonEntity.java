package it.engineering.spring.mvc.ds.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "contact_person")
public class ContactPersonEntity implements it.engineering.spring.mvc.ds.entity.Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private ManufacturerEntity manufacturerEntity;

    public ContactPersonEntity(Long id, String firstname, String lastname, ManufacturerEntity manufacturerEntity) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.manufacturerEntity = manufacturerEntity;
    }

    public ContactPersonEntity() {
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

    public ManufacturerEntity getManufacturerEntity() {
        return manufacturerEntity;
    }

    public void setManufacturerEntity(ManufacturerEntity manufacturerEntity) {
        this.manufacturerEntity = manufacturerEntity;
    }

    @Override
    public String toString() {
        return "ContactPersonEntity{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", manufacturerEntity=" + manufacturerEntity +
                '}';
    }
}
