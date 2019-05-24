package br.com.unipe.validator;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("datanascimentoValidator")
public class DataNascimentoValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object data) throws ValidatorException {

		Date dtNasc = (Date) data;
		Date dtAtual = new Date();

		@SuppressWarnings("deprecation")
		int idade = dtAtual.getYear() - dtNasc.getYear();

		if (idade < 18) {
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Idade menor que 18 anos!",
					"idade menor que 18 anos!");
			throw new ValidatorException(fm);
		}
	}

}