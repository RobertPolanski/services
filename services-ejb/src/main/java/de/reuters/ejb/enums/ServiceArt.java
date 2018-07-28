package de.reuters.ejb.enums;


public enum ServiceArt {

    DECODER("Decoder"),
    WEB("Web");


    ServiceArt(String name){
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }


}
