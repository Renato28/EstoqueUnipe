package br.com.unipe.enumerator;

public enum Cidades {

	JP("João Pessoa", "PB"), CG("Campina Grande", "PB"),
	RE("Recife", "PE"), OL("Olinda", "PE"),
	NT("Natal", "RN"), MO("Mossoró", "RN"),
	FO("Fortaleza", "CE"), JU("Juazeiro do Norte", "CE"),
	SA("Salvador", "BA"), IT("Itabuna", "BA"),
	SL("São Luiz", "MA"), IM("Imperatriz", "MA"),
	AR("Aracaju", "SE"), LG("Lagarto", "SE"),
	SP("São Paulo", "SP"), ST("Santos", "SP"),
	RJ("Rio de Janeiro", "RJ"), VR("Volta Redonda", "RJ"),
	BH("Belo Horizonte", "MG"), OP("Ouro Preto", "MG");

	private String label;
	private String estado;

	private Cidades(String label, String estado) {

		this.label = label;
		this.estado = estado;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
