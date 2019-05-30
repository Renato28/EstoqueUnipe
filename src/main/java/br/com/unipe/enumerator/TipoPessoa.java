package br.com.unipe.enumerator;

public enum TipoPessoa {

	PESSOA_FISICA("Fisica"), PESSOA_JURIDICA("Juridica");

	private String label;

	private TipoPessoa(String label) {

		this.label = label;
	}

	public static TipoPessoa create(String s) {

		TipoPessoa t = null;

		if (s.equals("Fisica")) {
			t = PESSOA_FISICA;
		} else if (s.equals("Juridica")) {
			t = PESSOA_JURIDICA;
		}
		return t;
	}

	@Override
	public String toString() {
		return label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
