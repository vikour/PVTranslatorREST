
package es.uma.a6.beans.validators;

import es.uma.a6.entitys.Modulo;
import es.uma.a6.service.I_pvtranslator.IPVTranslatorServer;
import es.uma.a6.service.pvtranslator.PVTranslatorServer;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("es.uma.a6.beans.validators.NombreModuloValidator")
public class NombreModuloValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
                
        IPVTranslatorServer server = PVTranslatorServer.getInstance();
        String nombre = value.toString();
        Modulo moduloActual = (Modulo) component.getAttributes().get("moduloActual");
        Modulo moduloServer;
        boolean creationMode = (Boolean) component.getAttributes().get("creationMode");
        
        if (nombre.isEmpty()) {
            FacesMessage message = new FacesMessage("Nombre inválido", "El nombre no puede estar vacío");
            throw new ValidatorException(message);
        }
        
        moduloServer = server.findModulo(nombre);
        
        if ( (creationMode && moduloServer != null) || 
             (!creationMode && !moduloActual.getNombre().equals(nombre) && moduloServer != null) ) {
            FacesMessage message = new FacesMessage("Nombre inválido", "Ya existe un módulo con ese nombre");
            throw new ValidatorException(message);
        }
        
    }
    
    
    
}
