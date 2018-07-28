package org.services.ws.assembler;

import java.util.List;

import org.services.ws.jaxb.ServiceDictWS;
import de.reuters.ejb.entity.ServiceDict;

public class ServiceDictAssembler {

	public static ServiceDictWS convertFromEjbToWS(ServiceDict serviceDict, ServiceDictWS serviceDictWS) {

		serviceDictWS.setId(serviceDict.getId());
		serviceDictWS.setName(serviceDict.getName());
		serviceDictWS.setServiceArt(serviceDict.getServiceArt());

		return serviceDictWS;
	}

	public static ServiceDict convertFromWSToEjb(ServiceDictWS serviceDictWS, ServiceDict serviceDict) {

		serviceDict.setId(serviceDictWS.getId());
		serviceDict.setName(serviceDictWS.getName());
		serviceDict.setServiceArt(serviceDictWS.getServiceArt());

		return serviceDict;
	}

	public static List<ServiceDictWS> convertListFromEjbToWS(List<ServiceDict> serviceDictList, List<ServiceDictWS> serviceDictWSList) {

		ServiceDict serviceDict = new ServiceDict();

		for (ServiceDictWS serviceDictWS : serviceDictWSList) {
			ServiceDictWS ServiceDictEJBToWS = convertFromEjbToWS(serviceDict, serviceDictWS);
			serviceDictWSList.add(ServiceDictEJBToWS);
		}

		return serviceDictWSList;
	}

}
