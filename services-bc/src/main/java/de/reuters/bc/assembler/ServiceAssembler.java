package de.reuters.bc.assembler;

import de.reuters.bc.dto.ServiceDto;
import de.reuters.ejb.entity.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rober on 20.08.2016.
 */
public class ServiceAssembler {

    public static ServiceDto convertFromEjbToDto(Service service) {
        ServiceDto serviceDto = new ServiceDto();
        serviceDto.setId(service.getId());
        serviceDto.setServiceName(service.getServiceName());
        return serviceDto;
    }

    public static List<ServiceDto> convertFromEjbToDto(List<Service> serviceList) {

        List<ServiceDto> serviceDtoList = new ArrayList<>();

        for(Service service : serviceList) {
            serviceDtoList.add(ServiceAssembler.convertFromEjbToDto(service));
        }
        return serviceDtoList;
    }
}
