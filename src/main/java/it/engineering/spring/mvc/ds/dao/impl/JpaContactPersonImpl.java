package it.engineering.spring.mvc.ds.dao.impl;

import it.engineering.spring.mvc.ds.dao.ContactPersonDao;
import it.engineering.spring.mvc.ds.entity.ContactPersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class JpaContactPersonImpl implements ContactPersonDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(ContactPersonEntity contactPersonEntity) throws Exception {
        entityManager.persist(contactPersonEntity);
    }

    @Override
    public List<ContactPersonEntity> getAll() throws Exception {
        return entityManager
                .createQuery("SELECT contact FROM ContactPersonEntity contact ORDER BY contact.firstname", ContactPersonEntity.class)
                .getResultList();
    }

    @Override
    public ContactPersonEntity findById(Long id) throws Exception {
        return entityManager.find(ContactPersonEntity.class, id);
    }

    @Override
    public void delete(Long id) throws Exception {
        entityManager
                .createQuery("DELETE FROM ContactPersonEntity contact WHERE contact.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public ContactPersonEntity update(ContactPersonEntity contactPersonEntity) throws Exception {
        return entityManager.merge(contactPersonEntity);
    }
}
