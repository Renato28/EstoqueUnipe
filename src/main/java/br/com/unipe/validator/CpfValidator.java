package br.com.unipe.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("cpfValidator")
public class CpfValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		String cpf = arg2.toString();
		if (cpf == null || 
				(cpf != null 
				&& (cpf.equals("") 
						|| cpf.length() < 11))) {
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cpf menor que 11 Caracteres",
					"Cpf menor que 11 Caracteres");
			throw new ValidatorException(fm);
		}
	}

}
