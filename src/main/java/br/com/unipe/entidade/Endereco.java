package br.com.unipe.entidade;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.unipe.enumerator.Cidades;
import br.com.unipe.enumerator.Estados;

public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Cidades municipio;

	
	private Estados estados;

	@NotEmpty
	private String bairro;

	@NotEmpty
	private Integer numero;

	@NotEmpty
	private String cep;

	@NotEmpty
	private String logradouros;

	public Cidades getMunicipios() {
		return municipio;
	}

	public void setMunicipios(Cidades municipios) {
		this.municipio = municipios;
	}

	public Estados getEstados() {
		return estados;
	}

	public void setEstados(Estados estados) {
		this.estados = estados;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouros() {
		return logradouros;
	}

	public void setLogradouros(String logradouros) {
		this.logradouros = logradouros;
	}

	public Cidades getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Cidades municipio) {
		this.municipio = municipio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((estados == null) ? 0 : estados.hashCode());
		result = prime * result + ((logradouros == null) ? 0 : logradouros.hashCode());
		result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (estados != other.estados)
			return false;
		if (logradouros == null) {
			if (other.logradouros != null)
				return false;
		} else if (!logradouros.equals(other.logradouros))
			return false;
		if (municipio != other.municipio)
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	
	

}
