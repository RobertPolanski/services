package de.reuters.bc.dto;

import java.util.ArrayList;
import java.util.List;

public class ServiceDto {
    private Long id;
    private String serviceName;
    private List<KundeDto> kundeList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<KundeDto> getKundeList() {
        return kundeList;
    }

    public void setKundeList(List<KundeDto> kundeList) {
        this.kundeList = kundeList;
    }
}
