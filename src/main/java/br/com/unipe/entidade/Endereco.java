package br.com.unipe.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.unipe.enumerator.Cidades;
import br.com.unipe.enumerator.Estados;
import br.com.unipe.enumerator.Logradouro;

@Entity
@Table(name = "Endereco")
public class Endereco implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	@NotEmpty
	private Logradouro logradouro;
	@Column(nullable = false)
	@NotEmpty
	private Cidades municipio;
	@Column(nullable = false)
	@NotEmpty
	private Estados estado;
	@Column(nullable = false)
	@NotEmpty
	@Length(min = 1, max = 9999)
	private Integer numero;
	@Length(min = 9)
	@Column(nullable = false)
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
