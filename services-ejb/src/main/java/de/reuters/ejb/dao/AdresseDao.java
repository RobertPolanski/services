package de.reuters.ejb.dao;

import de.reuters.ejb.entity.Adresse;

import javax.ejb.Local;


/**
 * Created by annpo on 02.05.2016.
 */

@Local
public interface AdresseDao {

    void fuegeAdresseHizu(Adresse adresse);

    void aktualisierAdresse(Adresse adresse);

    void entfernAdresse(Adresse adresse);

}
