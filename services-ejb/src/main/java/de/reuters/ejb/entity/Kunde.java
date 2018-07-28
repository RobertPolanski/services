package de.reuters.ejb.entity;

import de.reuters.ejb.enums.AdresseArt;
import de.reuters.ejb.enums.Geschlecht;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by annpo on 29.04.2016.
 * Für freunde "Nixe"
 */

@Entity
@Table(name = "KUNDE")
public class Kunde implements Serializable {

    @Id
    @GeneratedValue(generator = "KundeGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "KundeGenerator", sequenceName = "KUNDE_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GRUENDUNGSDATUM")
    private Date gruendungsdatum;

    @Column(name = "TELEFON")
    private String telefon;

    @Column(name = "GESCHLECHT")
    @Enumerated(EnumType.STRING)
    private Geschlecht geschlecht;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "kunde")
    private List<Service> serviceList;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "kunde")
    private List<Adresse> adresseList;

    public Adresse getAdresseVonKunden(AdresseArt adresseArt) {
        List<Adresse> adresseList = getAdresseList();

        for (Adresse adresse : adresseList) {
            if(adresse.getAdresseArt().equals(adresseArt)) {
                return adresse;
            }
        }

        return null;
    }

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

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public List<Adresse> getAdresseList() {
        return adresseList;
    }

    public void setAdresseList(List<Adresse> adresseList) {
        this.adresseList = adresseList;
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
