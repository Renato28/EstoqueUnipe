package br.com.unipe.entidade;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.unipe.enumerator.Cidades;
import br.com.unipe.enumerator.Estados;

public class Endereco extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String logradouro;

	private Cidades municipio;

	private Estados estado;

	@NotEmpty
	private String bairro;

	private String complemento;

	@NotEmpty
	private String numero;

	@NotEmpty
	private String cep;

	public Cidades getMunicipios() {
		return municipio;
	}

	public void setMunicipios(Cidades municipios) {
		this.municipio = municipios;
	}

	public Estados getEstados() {
		return estado;
	}

	public void setEstados(Estados estados) {
		this.estado = estados;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouros() {
		return logradouro;
	}

	public void setLogradouros(String logradouro) {
		this.logradouro = logradouro;
	}

	public Cidades getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Cidades municipio) {
		this.municipio = municipio;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
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
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		return true;
	}

}
