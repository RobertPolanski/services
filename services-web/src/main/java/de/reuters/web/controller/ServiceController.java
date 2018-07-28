package de.reuters.web.controller;

import de.reuters.bc.dto.ServiceDictDto;
import de.reuters.bc.dto.ServiceDto;
import de.reuters.bc.facade.ServiceDictFacade;
import de.reuters.bc.facade.ServiceFacade;
import de.reuters.ejb.enums.Services;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Named
@SessionScoped
public class ServiceController implements Serializable {

    private List<String> services = new ArrayList<>();
    private List<String> kundeServices = new ArrayList<>();

    private Long kundeId;

    @Inject
    private ServiceFacade serviceFacade;

    @Inject
    private ServiceDictFacade serviceDictFacade;

    public void init() {
        if(kundeServices.isEmpty() && services.isEmpty()) {

            clean();
/*
            Services[] servicesTab = Services.values();

            for (Services servicesEnum : servicesTab) {
                this.services.add(servicesEnum.getName());
            }
*/

            List<ServiceDictDto> listeVonServiceDict = serviceDictFacade.getListeVonServiceDict();

            for(ServiceDictDto serviceDictDto : listeVonServiceDict){
                services.add(serviceDictDto.getName());
            }


            List<ServiceDto> kundeServicesList = serviceFacade.getServiceListFuerKunde(kundeId);

            for (ServiceDto serviceDto : kundeServicesList) {
                kundeServices.add(serviceDto.getServiceName());
            }

            this.services.removeAll(kundeServices);
        }
    }

    private void clean() {
        kundeServices.clear();
        services.clear();
    }

    @SuppressWarnings("unchecked")
    public void servicesSelected(ValueChangeEvent event) {

        String[] newValues = (String[]) event.getNewValue();
        for (String selectItem : newValues) {
            services.remove(selectItem);
            kundeServices.add(selectItem);
        }
    }

    @SuppressWarnings("unchecked")
    public void kundeServicesSelected(ValueChangeEvent event) {
        String[] newValues = (String[]) event.getNewValue();
        for (String selectItem : newValues) {
            kundeServices.remove(selectItem);
            services.add(selectItem);
        }
    }

    public String updateServices() {
        serviceFacade.setServicesFuerKunde(kundeId, kundeServices);
        clean();
        return "/kundeListe";
    }

    public Long getKundeId() {
        return kundeId;
    }

    public void setKundeId(Long kundeId) {
        this.kundeId = kundeId;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public List<String> getKundeServices() {
        return kundeServices;
    }

    public void setKundeServices(List<String> kundeServices) {
        this.kundeServices = kundeServices;
    }

    public String cancel() {
        clean();
        return "/kundeListe.xhtml";
    }
}
