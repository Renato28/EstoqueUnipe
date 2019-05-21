package br.com.unipe.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.unipe.enumerator.Estados;

@FacesConverter("estadoConverter")
public class EstadoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.equals("")) {
			for (Estados estado : Estados.values()) {
				if (value.equals(estado.getLabel())) {
					return estado;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !value.equals("")) {
			Estados estado = (Estados) value;
			return estado.getLabel();
		}
		return "";
	}

}
