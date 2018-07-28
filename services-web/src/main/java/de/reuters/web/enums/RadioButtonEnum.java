package de.reuters.web.enums;

import de.reuters.ejb.enums.ServiceArt;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class RadioButtonEnum {

    public ServiceArt[] getServiceArt(){
        return ServiceArt.values();
    }
}
