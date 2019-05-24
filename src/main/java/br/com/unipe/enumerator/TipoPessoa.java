package br.com.unipe.enumerator;

public enum TipoPessoa {

	PF("Pessoa Fisica"), PJ("Pessoa Juridica");

	private String label;

	private TipoPessoa(String label) {

		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
