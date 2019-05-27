package br.com.unipe.validator;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.unipe.entidade.Usuario;
import br.com.unipe.enumerator.Usuarios;

@FacesValidator("usernameValidator")
public class UsernameValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		List<Usuario> list = Usuarios.INSTANCE.allUsers();
		String username = value.toString();
		
		if(list != null) {
			for(Usuario usuario : list) {
				if(usuario.getUsername().equals(username)) {
					FacesMessage fm  = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username já existente", "Username já existente");
					throw new ValidatorException(fm);
				}
			}
		}
	}

	
}