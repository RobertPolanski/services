package de.reuters.bc.facade.impl;

import de.reuters.bc.assembler.ServiceAssembler;
import de.reuters.bc.dto.ServiceDto;
import de.reuters.bc.facade.ServiceFacade;
import de.reuters.ejb.dao.KundeDao;
import de.reuters.ejb.dao.ServiceDao;
import de.reuters.ejb.dao.ServiceDictDao;
import de.reuters.ejb.entity.Kunde;
import de.reuters.ejb.entity.Service;
import de.reuters.ejb.entity.ServiceDict;
import de.reuters.ejb.enums.Services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ServiceFacadeImpl implements ServiceFacade {

    @EJB
    private ServiceDao serviceDao;

    @EJB
    private KundeDao kundeDao;

    @EJB
    private ServiceDictDao serviceDictDao;

    @Override
    public List<ServiceDto> getServiceListFuerKunde(Long kundeId) {
        return ServiceAssembler.convertFromEjbToDto(kundeDao.findKunde(kundeId).getServiceList());
    }

    @Override
    public void setServicesFuerKunde(Long kundeId, List<String> kundeServices) {

        Kunde kunde = kundeDao.findKunde(kundeId);

        for(Service service : kunde.getServiceList()) {
            service.setKunde(null);
            serviceDao.entfernService(service);
        }

        kunde.getServiceList().clear();


        List<Service> serviceList = new ArrayList<>();

        List<ServiceDict> kundeServiceDictList = new ArrayList<>();

        for (String kundeService: kundeServices) {

            ServiceDict kundeServiceDict = serviceDictDao.findServiceDict(kundeService);
            kundeServiceDictList.add(kundeServiceDict);
        }


        for(ServiceDict kundeServiceDict : kundeServiceDictList){

            Service service = new Service();
            service.setServiceName(kundeServiceDict.getName());
            service.setKunde(kunde);

            serviceDao.fuegeServiceHinzu(service);
            serviceList.add(service);

        }

        kunde.setServiceList(serviceList);
    }

}
