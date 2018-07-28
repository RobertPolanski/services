package org.services.ws.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import de.reuters.ejb.enums.ServiceArt;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceDictWS {
	
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
