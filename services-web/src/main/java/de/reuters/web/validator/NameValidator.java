package de.reuters.web.validator;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.io.Serializable;

@FacesValidator("nameValidator")
public class NameValidator implements Validator, Serializable{

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        String name = (String) o;

        if(name == null || name.trim().equals("")){

            throw new ValidatorException(
                    new FacesMessage("Der Name kann nicht leer sein")
            );
        }
    }
}
