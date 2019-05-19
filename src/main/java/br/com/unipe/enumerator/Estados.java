package br.com.unipe.enumerator;

public enum Estados {

	PB("Paraiba"), 
	PE("Pernambuco"), 
	RN("Rio Grande do Norte"), 
	CE("Cear�"), 
	BA("Bahia"), 
	MA("Maranh�o"), 
	SE("Sergipe"),
	SP("S�o Paulo"), 
	RJ("Rio de Janeiro"), 
	MG("Minas Gerais");

	private String label;

	private Estados(String label) {

		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
