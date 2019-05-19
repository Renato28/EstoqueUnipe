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

import br.com.unipe.enumerator.Cidade;
import br.com.unipe.enumerator.Estado;
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
	private Cidade municipio;
	@Column(nullable = false)
	@NotEmpty
	private Estado estado;
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

	public Cidade getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Cidade municipio) {
		this.municipio = municipio;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
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
