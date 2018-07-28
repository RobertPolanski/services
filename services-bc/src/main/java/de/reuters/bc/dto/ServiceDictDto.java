package de.reuters.bc.dto;

import de.reuters.ejb.enums.ServiceArt;
public class ServiceDictDto {

    private Long id;
    private String name;
    private ServiceArt serviceArt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceArt getServiceArt() {
        return serviceArt;
    }

    public void setServiceArt(ServiceArt serviceArt) {
        this.serviceArt = serviceArt;
    }
}
