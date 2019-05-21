package br.com.unipe.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.unipe.enumerator.Cidades;

@FacesConverter("cidadeConverter")
public class CidadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.equals("")) {
			for (Cidades cidade : Cidades.values()) {
				if (value.equals(cidade.getLabel())) {
					return cidade;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !value.equals("")) {
			Cidades cidade = (Cidades) value;
			return cidade.getLabel();
		}
		return "";
	}

}
