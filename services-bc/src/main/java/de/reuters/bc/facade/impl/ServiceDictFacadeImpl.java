package de.reuters.bc.facade.impl;

import de.reuters.bc.assembler.ServiceDictAssembler;
import de.reuters.bc.dto.ServiceDictDto;
import de.reuters.bc.facade.ServiceDictFacade;
import de.reuters.ejb.dao.ServiceDictDao;
import de.reuters.ejb.entity.ServiceDict;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ServiceDictFacadeImpl implements ServiceDictFacade {

    @EJB
    private ServiceDictDao serviceDictDao;

    @Override
    public List<ServiceDictDto> getListeVonServiceDict() {
        return ServiceDictAssembler.convertListFromEjbToTdo(serviceDictDao.getListeVonServiceDict());
    }

    @Override
    public ServiceDictDto findServiceDictDto(Long serviceDictId) {
        return ServiceDictAssembler.convertFromEjbToTdo(serviceDictDao.findServiceDict(serviceDictId));
    }

    @Override
    public void updateServiceDict(ServiceDictDto serviceDictDto) {
        ServiceDict serviceDictAusDerDatenbank = serviceDictDao.findServiceDict(serviceDictDto.getId());
        serviceDictDao.aktualisierServiceDict(serviceDictAusDerDatenbank);
    }

    @Override
    public void saveServiceDictDto(ServiceDictDto serviceDictDto) {
        serviceDictDao.fuegeServiceDictHinzu(ServiceDictAssembler.convertFromTdoToEjb(serviceDictDto));
    }

    @Override
    public void deleteServiceDict(Long serviceDictId) {
        ServiceDict serviceDict = serviceDictDao.findServiceDict(serviceDictId);
        serviceDictDao.entfernServiceDict(serviceDict);
    }

    @Override
    public ServiceDictDto findServiceDictDto(String name) {
        return ServiceDictAssembler.convertFromEjbToTdo(serviceDictDao.findServiceDict(name));

    }
}
