package de.reuters.ejb.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by annpo on 29.04.2016.
 */
@Entity
@Table(name = "SERVICE")
public class Service implements Serializable {

    @Id
    @GeneratedValue(generator = "ServiceGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ServiceGenerator", sequenceName = "SERVICE_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "SERVICE_NAME")
    private String serviceName;

    @ManyToOne
    @JoinColumn(name="KUNDE_ID")
    private Kunde kunde;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
