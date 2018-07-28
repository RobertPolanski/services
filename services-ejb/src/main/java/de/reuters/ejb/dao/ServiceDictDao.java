package de.reuters.ejb.dao;

import de.reuters.ejb.entity.ServiceDict;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ServiceDictDao {

    void fuegeServiceDictHinzu(ServiceDict serviceDict);

    void aktualisierServiceDict(ServiceDict serviceDict);

    void entfernServiceDict(ServiceDict serviceDict);

    List<ServiceDict> getListeVonServiceDict();

    ServiceDict findServiceDict(Long serviceDictId);

    void entfernServiceDict(Long serviceDictId);

    ServiceDict findServiceDict (String name);
}
