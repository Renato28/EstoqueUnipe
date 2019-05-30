package br.com.unipe.converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("cepConverter")
public class CepConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		if (value != null && !value.equals("")) {
			String semPontuacao = value.replaceAll("-" , "");
			return semPontuacao;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !value.equals("")) {
			String cep = (String) value;
			cep = cep.substring(0, 5) + "" + cep.substring(5, 8);
			return cep;
		}
		return "";
	}

}
