package de.reuters.bc.facade;

import de.reuters.bc.dto.ServiceDictDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ServiceDictFacade {

    List<ServiceDictDto> getListeVonServiceDict();

    ServiceDictDto findServiceDictDto(Long serviceDictId);

    void updateServiceDict(ServiceDictDto serviceDictDto);

    void saveServiceDictDto(ServiceDictDto serviceDictDto);

    void deleteServiceDict(Long serviceDictId);

    ServiceDictDto findServiceDictDto (String name);
}
