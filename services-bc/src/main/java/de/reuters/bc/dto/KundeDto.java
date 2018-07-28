package de.reuters.bc.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.reuters.ejb.enums.Geschlecht;

public class KundeDto {
    private Long id;
    private String name;
    private Date gruendungsdatum;
    private String telefon;
    private List<ServiceDto> serviceList = new ArrayList<>();
    private AdresseDto staendigeAdresse;
    private AdresseDto postAnschrift;
    private Geschlecht geschlecht;

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

    public Date getGruendungsdatum() {
        return gruendungsdatum;
    }

    public void setGruendungsdatum(Date gruendungsdatum) {
        this.gruendungsdatum = gruendungsdatum;
    }

    public List<ServiceDto> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<ServiceDto> serviceList) {
        this.serviceList = serviceList;
    }

    public AdresseDto getStaendigeAdresse() {
        return staendigeAdresse;
    }

    public void setStaendigeAdresse(AdresseDto staendigeAdresse) {
        this.staendigeAdresse = staendigeAdresse;
    }

    public AdresseDto getPostAnschrift() {
        return postAnschrift;
    }

    public void setPostAnschrift(AdresseDto postAnschrift) {
        this.postAnschrift = postAnschrift;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

	public Geschlecht getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(Geschlecht geschlecht) {
		this.geschlecht = geschlecht;
	}

    
}
