package br.com.unipe.enumerator;

public enum TipoItem {

	ALIMENTO("Alimento"), 
	ELETRODOMESTICO("Eletrodomestico"),
	ELETROPORTATEIS("Eletroportateis"),
	INFORMATICA("Informatica");

	private String label;

	private TipoItem(String label) {

		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean contains(String filtro) {
		return false;
	}

}
