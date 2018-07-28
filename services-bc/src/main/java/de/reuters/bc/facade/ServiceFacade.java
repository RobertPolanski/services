package de.reuters.bc.facade;

import de.reuters.bc.dto.ServiceDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ServiceFacade {

    List<ServiceDto> getServiceListFuerKunde(Long kundeId);

    void setServicesFuerKunde(Long kundeId, List<String> kundeServices);
}
