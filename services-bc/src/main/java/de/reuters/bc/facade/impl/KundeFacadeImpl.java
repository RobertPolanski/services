package de.reuters.bc.facade.impl;

import de.reuters.bc.assembler.KundeAssembler;
import de.reuters.bc.dto.KundeDto;
import de.reuters.bc.facade.KundeFacade;
import de.reuters.ejb.dao.AdresseDao;
import de.reuters.ejb.dao.KundeDao;
import de.reuters.ejb.entity.Adresse;
import de.reuters.ejb.entity.Kunde;
import de.reuters.ejb.enums.Geschlecht;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class KundeFacadeImpl implements KundeFacade {
    @EJB
    private KundeDao kundeDao;

    public List<KundeDto> getListeVonKunden(String kundeNameVomFilter, String telefonVomFilter, Geschlecht geschlechtVomFilter){
         return KundeAssembler.convertFromEjbToDto(kundeDao.getListeVonKunden(kundeNameVomFilter, telefonVomFilter, geschlechtVomFilter));
    }

    @Override
    public KundeDto findKunde(Long kundeId) {
        return KundeAssembler.convertFromEjbToDto(kundeDao.findKunde(kundeId));
    }

    @Override
    public void updateKunde(KundeDto kunde) {
        Kunde kundeAusDatenbank = kundeDao.findKunde(kunde.getId());
        kundeDao.aktualisierKunde(KundeAssembler.convertFromDtoToEjb(kunde, kundeAusDatenbank));
    }

    @Override
    public void saveKunde(KundeDto kunde) {
        kundeDao.fuegeKundeHinzu(KundeAssembler.convertFromDtoToEjb(kunde, new Kunde()));
    }

    @Override
    public void deleteKunde(Long kundeId) {
        Kunde kunde = kundeDao.findKunde(kundeId);
        kundeDao.entfernKunde(kunde);
    }


}
