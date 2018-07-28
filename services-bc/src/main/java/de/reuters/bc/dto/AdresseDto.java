package de.reuters.bc.dto;

import de.reuters.ejb.enums.AdresseArt;

/**
 * Created by rober on 20.08.2016.
 */
public class AdresseDto {

    private Long id;
    private String ort;
    private String strasse;
    private Integer hausNr;
    private Integer wohnungNr;
    private AdresseArt adresseArt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public Integer getHausNr() {
        return hausNr;
    }

    public void setHausNr(Integer hausNr) {
        this.hausNr = hausNr;
    }

    public Integer getWohnungNr() {
        return wohnungNr;
    }

    public void setWohnungNr(Integer wohnungNr) {
        this.wohnungNr = wohnungNr;
    }

    public AdresseArt getAdresseArt() {
        return adresseArt;
    }

    public void setAdresseArt(AdresseArt adresseArt) {
        this.adresseArt = adresseArt;
    }
}
