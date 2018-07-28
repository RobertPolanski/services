package de.reuters.ejb.entity;

import de.reuters.ejb.enums.ServiceArt;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "SERVICE_DICT")
public class ServiceDict implements Serializable {

    @Id
    @GeneratedValue(generator = "ServiceDictGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ServiceDictGenerator", sequenceName = "SERVICE_DICT_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SERVICE_ART")
    @Enumerated(EnumType.STRING)
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
