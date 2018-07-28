package de.reuters.bc.facade;

import de.reuters.bc.dto.KundeDto;
import de.reuters.ejb.dao.KundeDao;
import de.reuters.ejb.entity.Kunde;
import de.reuters.ejb.enums.Geschlecht;

import javax.ejb.Local;
import java.util.List;

@Local
public interface KundeFacade {

    KundeDto findKunde(Long kundeId);

    void updateKunde(KundeDto kunde);

    void saveKunde(KundeDto kunde);

    void deleteKunde(Long kundeId);

    List<KundeDto> getListeVonKunden(String kundeNameVomFilter, String telefonVomFilter, Geschlecht geschlechtVomFilter);
    
}
