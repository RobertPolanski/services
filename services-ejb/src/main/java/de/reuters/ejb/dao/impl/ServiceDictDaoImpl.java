package de.reuters.ejb.dao.impl;

import de.reuters.ejb.dao.ServiceDictDao;
import de.reuters.ejb.entity.ServiceDict;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ServiceDictDaoImpl implements ServiceDictDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void fuegeServiceDictHinzu(ServiceDict serviceDict) {
        entityManager.persist(serviceDict);
    }

    @Override
    public void aktualisierServiceDict(ServiceDict serviceDict) {
        entityManager.merge(serviceDict);
    }

    @Override
    public void entfernServiceDict(ServiceDict serviceDict) {
        entityManager.remove(serviceDict);
    }

    @Override
    public List<ServiceDict> getListeVonServiceDict() {

        List resultList = entityManager.createQuery("SELECT s FROM ServiceDict s").getResultList();
        return resultList;
    }

    @Override
    public ServiceDict findServiceDict(Long serviceDictId) {
        return entityManager.find(ServiceDict.class, serviceDictId);
    }

    @Override
    public void entfernServiceDict(Long serviceDictId) {
        entityManager.createQuery("delete from ServiceDict s where s.id = :id").setParameter("id", serviceDictId).executeUpdate();
    }

    @Override
    public ServiceDict findServiceDict(String serviceDictName) {
        return (ServiceDict) entityManager.createQuery("SELECT s FROM ServiceDict s where s.name = :serviceDictName").
                setParameter("serviceDictName", serviceDictName).getSingleResult();
    }
}
