package de.reuters.web.controller;

import de.reuters.bc.dto.ServiceDictDto;
import de.reuters.bc.facade.ServiceDictFacade;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@SessionScoped
public class ServiceDictController implements Serializable {

    private final static String ADD = "add";
    private final static String EDIT = "edit";
    private final static String DELETE = "delete";

    private ServiceDictDto serviceDictDto;
    private String operation;

    private Long serviceDictId;

    @Inject
    private ServiceDictFacade serviceDictFacade;

    public void init() {
        switch (operation) {
            case EDIT:
                FacesContext ctx = FacesContext.getCurrentInstance();
                if (!ctx.isValidationFailed()) {
                    serviceDictDto = findServiceDictDto(serviceDictId);
                }
                break;
            case ADD:
                serviceDictDto = new ServiceDictDto();
                break;
        }
    }

    private ServiceDictDto findServiceDictDto(Long kundeId) {
        return serviceDictFacade.findServiceDictDto(kundeId);
    }


    public List<ServiceDictDto> getServiceDictListDto(){
        return serviceDictFacade.getListeVonServiceDict();
    }

    public String updateServiceDictDto() {
        switch (operation) {
            case EDIT:
                serviceDictFacade.updateServiceDict(serviceDictDto);
                break;
            case ADD:
                serviceDictFacade.saveServiceDictDto(serviceDictDto);
                break;
            case DELETE:
                serviceDictFacade.deleteServiceDict(serviceDictId);
                break;
        }
        return "/serviceDictListe";
    }




    public ServiceDictDto getServiceDictDto() {
        return serviceDictDto;
    }

    public void setServiceDictDto(ServiceDictDto serviceDictDto) {
        this.serviceDictDto = serviceDictDto;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Long getServiceDictId() {
        return serviceDictId;
    }

    public void setServiceDictId(Long serviceDictId) {
        this.serviceDictId = serviceDictId;
    }

    public ServiceDictFacade getServiceDictFacade() {
        return serviceDictFacade;
    }

    public void setServiceDictFacade(ServiceDictFacade serviceDictFacade) {
        this.serviceDictFacade = serviceDictFacade;
    }
}
