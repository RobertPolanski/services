package de.reuters.ejb.dao;

import de.reuters.ejb.entity.Kunde;
import de.reuters.ejb.enums.Geschlecht;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by annpo on 02.05.2016.
 */

@Local
public interface KundeDao {

    void fuegeKundeHinzu(Kunde kunde);

    void aktualisierKunde(Kunde kunde);

    void entfernKunde(Kunde kunde);

    List<Kunde> getListeVonKunden(String kundeNameVomFilter, String telefonVomFilter, Geschlecht geschlechtVomFilter);

    Kunde findKunde(Long kundeId);

    void entfernKunde(Long kundeId);
}
