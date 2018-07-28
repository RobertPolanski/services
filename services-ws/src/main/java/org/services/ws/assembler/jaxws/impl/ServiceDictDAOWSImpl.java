 package org.services.ws.assembler.jaxws.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.services.ws.assembler.ServiceDictAssembler;
import org.services.ws.assembler.jaxws.ServiceDictDAOWS;
import org.services.ws.jaxb.ServiceDictWS;

import de.reuters.ejb.dao.ServiceDictDao;
import de.reuters.ejb.entity.ServiceDict;



@Stateless
public class ServiceDictDAOWSImpl implements ServiceDictDAOWS{
	
	@EJB
    private ServiceDictDao serviceDictDao;

	@Override
	public List<ServiceDictWS> getListeVonServiceDict() {
		
		List<ServiceDict> listeVonServiceDict = serviceDictDao.getListeVonServiceDict();
		List<ServiceDictWS> listeVonServiceDictWS = new ArrayList<>();
		
		List<ServiceDictWS> convertedListFromEjbToWS = ServiceDictAssembler.convertListFromEjbToWS(listeVonServiceDict, listeVonServiceDictWS);
		
		return convertedListFromEjbToWS;
	}

	@Override
	public ServiceDictWS findServiceDictWS(Long serviceDictId) {
		
		ServiceDictWS serviceDictWS = new ServiceDictWS();
		ServiceDictWS convertFromEjbToWS = ServiceDictAssembler.convertFromEjbToWS(serviceDictDao.findServiceDict(serviceDictId), serviceDictWS);
		
		return convertFromEjbToWS;
	}

	@Override
	public void updateServiceDictWS(ServiceDictWS serviceDictWS) {
		
		ServiceDict serviceDictAusDatenbank = serviceDictDao.findServiceDict(serviceDictWS.getId());
		serviceDictDao.aktualisierServiceDict(serviceDictAusDatenbank);
	}

	@Override
	public void saveServiceDictWS(ServiceDictWS serviceDictWS) {
		
		ServiceDict serviceDict = new ServiceDict();
		ServiceDict convertFromWSToEjb = ServiceDictAssembler.convertFromWSToEjb(serviceDictWS, serviceDict);
		serviceDictDao.fuegeServiceDictHinzu(convertFromWSToEjb);
		
	}

	@Override
	public void deleteServiceDictWS(Long serviceDictId) {
		
		ServiceDict serviceDictAusDatenbank = serviceDictDao.findServiceDict(serviceDictId);
		serviceDictDao.entfernServiceDict(serviceDictAusDatenbank);
		
	}

	@Override
	public ServiceDictWS findServiceDictWS(String name) {
		
		ServiceDict serviceDict = serviceDictDao.findServiceDict(name);
		ServiceDictWS serviceDictWS = new ServiceDictWS();
		ServiceDictWS convertFromEjbToWS = ServiceDictAssembler.convertFromEjbToWS(serviceDict, serviceDictWS);
		
		return convertFromEjbToWS;
	}
	
	

}
