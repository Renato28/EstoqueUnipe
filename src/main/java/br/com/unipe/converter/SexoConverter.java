package br.com.unipe.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.unipe.enumerator.Sexo;

@FacesConverter("sexoConverter")
public class SexoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.equals("")) {
			for (Sexo sexo : Sexo.values()) {
				if (value.equals(sexo.getLabel())) {
					return sexo;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !value.equals("")) {
			Sexo sexo = (Sexo) value;
			return sexo.getLabel();
		}
		return "";
	}

}
