package de.reuters.ejb.dao.impl;

import de.reuters.ejb.entity.Adresse;
import de.reuters.ejb.dao.AdresseDao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Created by annpo on 02.05.2016.
 */

@Stateless
public class AdresseDaoImpl implements AdresseDao {

    @PersistenceContext
    private EntityManager em;

    public void fuegeAdresseHizu(Adresse adresse){
        em.persist(adresse);
    }

    public void aktualisierAdresse(Adresse adresse){
        em.merge(adresse);
    }

    public void entfernAdresse(Adresse adresse){
        em.remove(adresse);
    }

}
