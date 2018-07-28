package de.reuters.ejb.enums;

/**
 * Created by rober on 20.08.2016.
 */
public enum Services {

    REUTERS_SERWIS_POLSKI(0L, "Reuters Serwis Polski", ServiceArt.DECODER),
    REUTERS_TRADER_EASTERN_EUROPE(1L, "Reuters Trader Eastern Europe", ServiceArt.WEB),
    KONDOR(2L, "Kondor", ServiceArt.DECODER),
    REUTERS_KNOWLEDGE(3L, "Reuters Knowledge", ServiceArt.WEB);

    Services(Long id, java.lang.String name, ServiceArt serviceArt) {
        this.id = id;
        this.name = name;
        this.serviceArt = serviceArt;
    }

    private Long id;
    private java.lang.String name;
    private ServiceArt serviceArt;

    public java.lang.String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public static Services findById(Long id) {
        for (Services services : values()) {
            if (services.getId().equals(id)) {
                return services;
            }
        }
        throw new IllegalArgumentException("Wert nicht richtig: " + id);
    }

    public static Services findByName(java.lang.String name) {
        for (Services services : values()) {
            if (services.getName().equals(name)) {
                return services;
            }
        }
        throw new IllegalArgumentException("Wert nicht richtig: " + name);
    }
}
