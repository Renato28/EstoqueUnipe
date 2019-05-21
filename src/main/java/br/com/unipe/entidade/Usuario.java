package br.com.unipe.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import br.com.unipe.enumerator.Sexo;
import br.com.unipe.enumerator.TipoPessoa;

public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Length(min = 30)

	@NotEmpty
	private String nome;

	@NotEmpty
	private String username;

	@Length(min = 8, max = 16)
	@NotEmpty
	private String password;

	@NotEmpty
	private Endereco endereco;

	@NotEmpty
	@Email
	private String email;

	@Past

	@NotEmpty
	private Date dataNasc;

	@NotEmpty
	private Sexo sexo;

	@NotEmpty
	private TipoPessoa pessoa;

	@NotEmpty
	@CPF
	private String cpf;

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
