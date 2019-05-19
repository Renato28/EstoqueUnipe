package br.com.unipe.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import br.com.unipe.enumerator.Sexo;
import br.com.unipe.enumerator.TipoPessoa;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Length(min = 30)
	@Column(nullable = false)
	@NotEmpty
	private String nome;

	@Column(nullable = false)
	@NotEmpty
	private String username;

	@Column(nullable = false)
	@Length(min = 8, max = 16)
	@NotEmpty
	private String password;
	
	@Column(nullable = false)
	@NotEmpty
	private Endereco endereco;

	@Column(nullable = false)
	@NotEmpty
	@Email
	private String email;

	@Past
	@Column(nullable = false)
	@NotEmpty
	private Date dataNasc;

	@Column(nullable = false)
	@NotEmpty
	private Sexo sexo;

	@Column(nullable = false)
	@NotEmpty
	private TipoPessoa pessoa;

	@Column(nullable = false)
	@NotEmpty
	@CPF
	private String cpf;

	@Column(nullable = false)
	@NotEmpty
	@CNPJ
	private String cnpj;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public TipoPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(TipoPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
