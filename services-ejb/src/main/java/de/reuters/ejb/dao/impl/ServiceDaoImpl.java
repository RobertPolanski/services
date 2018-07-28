package de.reuters.ejb.dao.impl;

import de.reuters.ejb.entity.Service;
import de.reuters.ejb.dao.ServiceDao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by annpo on 02.05.2016.
 */

@Stateless
public class ServiceDaoImpl implements ServiceDao {

    @PersistenceContext
    private EntityManager em;

    public void fuegeServiceHinzu(Service service){
        em.persist(service);
    }

    public void aktualisierService(Service service){
        em.merge(service);
    }

    public void entfernService(Service service){
        em.remove(service);
    }

    @Override
    public List<Service> liesServices(List<String> kundeServices) {
        List resultList = em.createQuery("SELECT s FROM Service s where s.name in(:serviceNameList)").setParameter("serviceNameList", kundeServices).getResultList();
        return resultList;
    }
}
