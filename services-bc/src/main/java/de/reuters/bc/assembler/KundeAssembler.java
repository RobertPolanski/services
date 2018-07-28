package de.reuters.bc.assembler;

import de.reuters.bc.dto.KundeDto;
import de.reuters.ejb.entity.Adresse;
import de.reuters.ejb.entity.Kunde;
import de.reuters.ejb.enums.AdresseArt;

import java.util.ArrayList;
import java.util.List;

public final class KundeAssembler {

    public static List<KundeDto> convertFromEjbToDto(List<Kunde> kundeList) {
        List<KundeDto> kundeDtoList = new ArrayList<>();

        for (Kunde kunde : kundeList) {
            kundeDtoList.add(convertFromEjbToDto(kunde));
        }

        return kundeDtoList;
    }

    public static KundeDto convertFromEjbToDto(Kunde kunde) {
        KundeDto kundeDto = new KundeDto();

        kundeDto.setId(kunde.getId());
        kundeDto.setName(kunde.getName());
        kundeDto.setGruendungsdatum(kunde.getGruendungsdatum());
        kundeDto.setTelefon(kunde.getTelefon());
        kundeDto.setGeschlecht(kunde.getGeschlecht());

        kundeDto.setStaendigeAdresse(AdresseAssembler.convertFromEjbToDto(kunde.getAdresseVonKunden(AdresseArt.STAENDIGE)));
        kundeDto.setPostAnschrift(AdresseAssembler.convertFromEjbToDto(kunde.getAdresseVonKunden(AdresseArt.POST)));

        return kundeDto;
    }

    public static Kunde convertFromDtoToEjb(KundeDto kundeDto, Kunde kunde) {

        kunde.setId(kundeDto.getId());
        kunde.setName(kundeDto.getName());
        kunde.setGruendungsdatum(kundeDto.getGruendungsdatum());
        kunde.setTelefon(kundeDto.getTelefon());
        kunde.setGeschlecht(kundeDto.getGeschlecht());

        List<Adresse> adresseList = new ArrayList<>();

        Adresse staendigeAdresse = AdresseAssembler.convertFromDtoToEjb(kundeDto.getStaendigeAdresse());
        staendigeAdresse.setKunde(kunde);

        Adresse postAnschrift = AdresseAssembler.convertFromDtoToEjb(kundeDto.getPostAnschrift());
        postAnschrift.setKunde(kunde);

        adresseList.add(staendigeAdresse);
        adresseList.add(postAnschrift);

        kunde.setAdresseList(adresseList);

        return kunde;
    }


}
