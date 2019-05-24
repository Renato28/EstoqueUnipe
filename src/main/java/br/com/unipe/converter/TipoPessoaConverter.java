package br.com.unipe.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.unipe.enumerator.TipoPessoa;

@FacesConverter("tipopessoaConverter")
public class TipoPessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.equals("")) {
			for (TipoPessoa tipo : TipoPessoa.values()) {
				if (value.equals(tipo.getLabel())) {
					return tipo;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !value.equals("")) {
			TipoPessoa tipo = (TipoPessoa) value;
			return tipo.getLabel();
		}
		return "";
	}

}
