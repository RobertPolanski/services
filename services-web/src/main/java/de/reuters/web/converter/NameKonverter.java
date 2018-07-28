package de.reuters.web.converter;

import de.reuters.bc.utils.StringUtil;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("nameKonverter")
public class NameKonverter implements Converter {


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String name) {

        String amAnfangDesWortesGrosseBuchstaben = StringUtil.machAmAnfangDesWortesGrosseBuchstaben(name);

        return amAnfangDesWortesGrosseBuchstaben;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {

        String name = (String) o;

        String amAnfangDesWortesGrosseBuchstaben = StringUtil.machAmAnfangDesWortesGrosseBuchstaben(name);

        return amAnfangDesWortesGrosseBuchstaben;
    }
}
