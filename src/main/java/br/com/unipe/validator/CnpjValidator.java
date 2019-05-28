package br.com.unipe.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("cnpjValidator")
public class CnpjValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		String cnpj = arg2.toString();
		if (cnpj == null || (cnpj != null && (cnpj.equals("") || cnpj.length() < 14))) {
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cnpj menor que 14 Caracteres",
					"Cnpj menor que 14 Caracteres");
			throw new ValidatorException(fm);
		}
	}

}
