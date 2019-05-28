package br.com.unipe.bean;

import javax.faces.bean.ManagedBean;

import br.com.unipe.entidade.Pessoa;

@ManagedBean(name = "pessoaBean")
public class PessoaBean {

	private Pessoa pessoa;
	private Boolean isRederiza = false;
	
	public PessoaBean() {
		
		pessoa = new Pessoa();
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