package de.reuters.bc.assembler;

import de.reuters.bc.dto.AdresseDto;
import de.reuters.ejb.entity.Adresse;


/**
 * Created by rober on 20.08.2016.
 */
public final class AdresseAssembler {

    public static AdresseDto convertFromEjbToDto(Adresse adresse) {
        AdresseDto adresseDto = new AdresseDto();

        adresseDto.setId(adresse.getId());
        adresseDto.setHausNr(adresse.getHausNr());
        adresseDto.setOrt(adresse.getOrt());
        adresseDto.setStrasse(adresse.getStrasse());
        adresseDto.setWohnungNr(adresse.getWohnungNr());
        adresseDto.setAdresseArt(adresse.getAdresseArt());

        return adresseDto;
    }

    public static Adresse convertFromDtoToEjb(AdresseDto adresseDto) {
        Adresse adresse = new Adresse();
        adresse.setId(adresseDto.getId());
        adresse.setHausNr(adresseDto.getHausNr());
        adresse.setOrt(adresseDto.getOrt());
        adresse.setStrasse(adresseDto.getStrasse());
        adresse.setWohnungNr(adresseDto.getWohnungNr());
        adresse.setAdresseArt(adresseDto.getAdresseArt());
        return adresse;
    }
}
