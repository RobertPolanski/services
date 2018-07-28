package org.services.ws.assembler.jaxws;

import java.util.List;
import javax.jws.WebService;

import org.services.ws.jaxb.ServiceDictWS;

@WebService
public interface ServiceDictDAOWS {

	List<ServiceDictWS> getListeVonServiceDict();

	ServiceDictWS findServiceDictWS(Long serviceDictId);

	void updateServiceDictWS(ServiceDictWS serviceDictWS);

	void saveServiceDictWS(ServiceDictWS serviceDictWS);

	void deleteServiceDictWS(Long serviceDictId);

	ServiceDictWS findServiceDictWS(String name);

}
