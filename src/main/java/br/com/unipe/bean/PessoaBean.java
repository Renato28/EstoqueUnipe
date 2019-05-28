package br.com.unipe.bean;

import javax.faces.bean.ManagedBean;

import br.com.unipe.entidade.Pessoa;
import br.com.unipe.enumerator.TipoPessoa;

@ManagedBean(name = "pessoaBean")
public class PessoaBean {

	private Pessoa pessoa;
	private TipoPessoa tipo;
	private Boolean isRederiza = false;

	public PessoaBean() {

		pessoa = new Pessoa();
	}

	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Boolean getIsRederiza() {
		return isRederiza;
	}

	public void setIsRederiza(Boolean isRederiza) {
		this.isRederiza = isRederiza;
	}

	public void renderizar() {
		if (pessoa.getTipo().equals("J")) {
			isRederiza = true;
		} else {
			isRederiza = false;
		}
	}
}