package de.reuters.ejb.entity;

import de.reuters.ejb.enums.AdresseArt;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by annpo on 29.04.2016.
 */

@Entity
@Table(name = "ADRESSE")
public class Adresse implements Serializable {

    @Id
    @GeneratedValue(generator = "AdresseGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "AdresseGenerator", sequenceName = "ADRESSE_SEQ")
    @Column(name = "ID")
    private Long id;
    @Column(name = "ORT")
    private String ort;
    @Column(name = "STRASSE")
    private String strasse;
    @Column(name = "HAUS_NR")
    private Integer hausNr;
    @Column(name = "WOHNUNG_NR")
    private Integer wohnungNr;
    @Column(name = "ADRESSE_ART")
    private AdresseArt adresseArt;

    @ManyToOne
    @JoinColumn(name="KUNDE_ID")
    private Kunde kunde;

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

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
