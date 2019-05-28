package br.com.unipe.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class PessoaBean {

	private String opcao;
	private Boolean isRederiza = false;

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public Boolean getIsRederiza() {
		return isRederiza;
	}

	public void setIsRederiza(Boolean isRederiza) {
		this.isRederiza = isRederiza;
	}

	public void renderizar() {
		if (getOpcao().equals("J")) {
			isRederiza = true;
		} else {
			isRederiza = false;
		}
	}
}