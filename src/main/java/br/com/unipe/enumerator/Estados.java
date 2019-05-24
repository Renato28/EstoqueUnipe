package br.com.unipe.enumerator;

public enum Estados {

	PB("Paraiba"), 
	PE("Pernambuco"), 
	RN("Rio Grande do Norte"), 
	CE("Ceará"), 
	BA("Bahia"), 
	MA("Maranhão"), 
	SE("Sergipe"),
	SP("São Paulo"), 
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
