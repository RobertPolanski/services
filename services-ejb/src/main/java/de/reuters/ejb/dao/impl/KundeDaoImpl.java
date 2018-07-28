package de.reuters.ejb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import de.reuters.ejb.dao.KundeDao;
import de.reuters.ejb.entity.Kunde;
import de.reuters.ejb.enums.Geschlecht;


/**
 * Created by annpo on 02.05.2016.
 */

@Stateless
public class KundeDaoImpl implements KundeDao {


    @PersistenceContext
    private EntityManager em;

    public void fuegeKundeHinzu(Kunde kunde){
        em.persist(kunde);
    }

    public void aktualisierKunde(Kunde kunde){
        em.merge(kunde);
    }


    public void entfernKunde(Kunde kunde){
        em.remove(kunde);
    }


    public List<Kunde> getListeVonKunden(String kundeNameVomFilter, String telefonVomFilter, Geschlecht geschlechtVomFilter){

        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Kunde> cq = qb.createQuery(Kunde.class);
        Root<Kunde> root = cq.from(Kunde.class);

        
        List<Predicate> predicates = new ArrayList<>();
        
        if (kundeNameVomFilter != null && ! kundeNameVomFilter.equals("")) {
            predicates.add(qb.like(root.<String>get("name"), "%" + kundeNameVomFilter + "%"));
        }

        if(kundeNameVomFilter == null || kundeNameVomFilter.equals("")) {
            cq.select(root);
        } else {
            cq.select(root).where(predicates.toArray(new Predicate[]{}));
        }
        
        

        if (telefonVomFilter != null && ! telefonVomFilter.equals("")) {
            predicates.add(qb.equal(root.<String>get("telefon"), telefonVomFilter));
        }

        if(telefonVomFilter == null || telefonVomFilter.equals("")) {
            cq.select(root);
        } else {
            cq.select(root).where(predicates.toArray(new Predicate[]{}));
        }

        
        
        if (geschlechtVomFilter != null && ! geschlechtVomFilter.equals("")) {
            predicates.add(qb.equal(root.<String>get("geschlecht"), geschlechtVomFilter));
        }

        if(geschlechtVomFilter == null || geschlechtVomFilter.equals("")) {
            cq.select(root);
        } else {
            cq.select(root).where(predicates.toArray(new Predicate[]{}));
        }
        
        return em.createQuery(cq).getResultList();
    }

    @Override
    public Kunde findKunde(Long kundeId) {
        return em.find(Kunde.class, kundeId);
    }

    @Override
    public void entfernKunde(Long kundeId) {
        em.createQuery("delete from Kunde k where k.id = :id").setParameter("id", kundeId).executeUpdate();
    }


}

