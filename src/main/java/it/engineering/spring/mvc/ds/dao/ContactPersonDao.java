package it.engineering.spring.mvc.ds.dao;

import it.engineering.spring.mvc.ds.entity.ContactPersonEntity;

import java.util.List;

public interface ContactPersonDao {
    void save(ContactPersonEntity contactPersonEntity) throws Exception;
    List<ContactPersonEntity> getAll() throws Exception;
    ContactPersonEntity findById(Long id) throws Exception;
    void delete(Long id) throws Exception;
    ContactPersonEntity update(ContactPersonEntity contactPersonEntity) throws Exception;
}
