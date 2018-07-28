package de.reuters.bc.assembler;

import de.reuters.bc.dto.ServiceDictDto;
import de.reuters.ejb.entity.ServiceDict;

import java.util.ArrayList;
import java.util.List;

public class ServiceDictAssembler {

    public static ServiceDictDto convertFromEjbToTdo(ServiceDict serviceDict){

        ServiceDictDto serviceDictDto = new ServiceDictDto();

        serviceDictDto.setId(serviceDict.getId());
        serviceDictDto.setName(serviceDict.getName());
        serviceDictDto.setServiceArt(serviceDict.getServiceArt());

        return serviceDictDto;
    }


    public static ServiceDict convertFromTdoToEjb(ServiceDictDto serviceDictDto){

        ServiceDict serviceDict = new ServiceDict();

        serviceDict.setId(serviceDictDto.getId());
        serviceDict.setName(serviceDictDto.getName());
        serviceDict.setServiceArt(serviceDictDto.getServiceArt());

        return serviceDict;
    }


    public static List<ServiceDictDto> convertListFromEjbToTdo(List<ServiceDict> serviceDictList){

        List<ServiceDictDto> serviceDictDtoList = new ArrayList<>();

        for(ServiceDict serviceDict : serviceDictList){

            ServiceDictDto serviceDictDto = convertFromEjbToTdo(serviceDict);
            serviceDictDtoList.add(serviceDictDto);
        }

        return serviceDictDtoList;

    }
}
