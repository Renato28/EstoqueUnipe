package br.com.unipe.entidade;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.unipe.enumerator.Cidades;
import br.com.unipe.enumerator.Estados;
import br.com.unipe.enumerator.Logradouro;

public class Endereco implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@NotEmpty
	private Logradouro logradouro;
	
	@NotEmpty
	private Cidades municipio;
	
	@NotEmpty
	private Estados estado;
	
	@NotEmpty
	@Length(min = 1, max = 9999)
	private Integer numero;
	@Length(min = 9)
	
	@NotEmpty
	private String cep;

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public Cidades getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Cidades municipio) {
		this.municipio = municipio;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
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
