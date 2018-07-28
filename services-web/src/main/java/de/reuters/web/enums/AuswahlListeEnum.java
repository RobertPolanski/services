package de.reuters.web.enums;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import de.reuters.ejb.enums.Geschlecht;


@Named
@ApplicationScoped
public class AuswahlListeEnum {
	
	public Geschlecht[] getGeschlechtArt(){
        return Geschlecht.values();
    }

}
