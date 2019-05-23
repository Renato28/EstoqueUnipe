package br.com.unipe.entidade;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.unipe.enumerator.Cidades;
import br.com.unipe.enumerator.Estados;
import br.com.unipe.enumerator.Logradouro;

public class Endereco {
	
	@NotEmpty
	private Logradouro logradouros;
	
	@NotEmpty
	private Cidades municipios;
	
	@NotEmpty
	private Estados estados;
	
	@NotEmpty
	private Integer numero;
	
	@NotEmpty
	private String cep;

	public Logradouro getLogradouros() {
		return logradouros;
	}

	public void setLogradouros(Logradouro logradouros) {
		this.logradouros = logradouros;
	}

	public Cidades getMunicipios() {
		return municipios;
	}

	public void setMunicipios(Cidades municipios) {
		this.municipios = municipios;
	}

	public Estados getEstados() {
		return estados;
	}

	public void setEstados(Estados estados) {
		this.estados = estados;
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

}
