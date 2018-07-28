package de.reuters.web.controller;

import de.reuters.bc.dto.AdresseDto;
import de.reuters.bc.dto.KundeDto;
import de.reuters.bc.facade.KundeFacade;
import de.reuters.ejb.enums.AdresseArt;
import de.reuters.ejb.enums.Geschlecht;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Durch Controller habe ich einen Zugriff aus EJB zu JSF über CDI und Annotation @Inject
 * @Named benutze ich im JSF
 */

@Named
@SessionScoped
public class KundeController implements Serializable{

    private final static String ADD = "add";
    private final static String EDIT = "edit";
    private final static String DELETE = "delete";

    private KundeDto kunde;
    private String operation;

    private Long kundeId;
    private String kundeNameVomFilter;
    private String telefonVomFilter;
    private Geschlecht geschlechtVomFilter;

    @Inject
    private KundeFacade kundeFacade;

    public void init() {
        switch (operation) {
            case EDIT:
                FacesContext ctx = FacesContext.getCurrentInstance();
                if (!ctx.isValidationFailed()) {
                    kunde = findKunde(kundeId);
                }
                break;
            case ADD:
                kunde = new KundeDto();

                AdresseDto staendigeAdresse = new AdresseDto();
                staendigeAdresse.setAdresseArt(AdresseArt.STAENDIGE);
                kunde.setStaendigeAdresse(staendigeAdresse);

                AdresseDto postanschrift = new AdresseDto();
                postanschrift.setAdresseArt(AdresseArt.POST);
                kunde.setPostAnschrift(postanschrift);
                break;
        }
    }

    private KundeDto findKunde(Long kundeId) {
        return kundeFacade.findKunde(kundeId);
    }


    public List<KundeDto> getKunden(){
        return kundeFacade.getListeVonKunden(kundeNameVomFilter, telefonVomFilter, geschlechtVomFilter);
    }

    public String updateKunde() {
        switch (operation) {
            case EDIT:
                kundeFacade.updateKunde(kunde);
                break;
            case ADD:
                kundeFacade.saveKunde(kunde);
                break;
            case DELETE:
                kundeFacade.deleteKunde(kundeId);
                break;
        }
        return "/kundeListe";
    }


    public KundeDto getKunde() {
        return kunde;
    }

    public void setKunde(KundeDto kunde) {
        this.kunde = kunde;
    }

    public Long getKundeId() {
        return kundeId;
    }

    public void setKundeId(Long kundeId) {
        this.kundeId = kundeId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getKundeNameVomFilter() {
        return kundeNameVomFilter;
    }

    public void setKundeNameVomFilter(String kundeNameVomFilter) {
        this.kundeNameVomFilter = kundeNameVomFilter;
    }

    public String getTelefonVomFilter() {
        return telefonVomFilter;
    }

    public void setTelefonVomFilter(String telefonVomFilter) {
        this.telefonVomFilter = telefonVomFilter;
    }

    public Geschlecht getGeschlechtVomFilter() {
		return geschlechtVomFilter;
	}

	public void setGeschlechtVomFilter(Geschlecht geschlechtVomFilter) {
		this.geschlechtVomFilter = geschlechtVomFilter;
	}

	public void searchFilter() {
        //empty
    }
}
