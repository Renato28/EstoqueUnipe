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

}
