package br.com.unipe.enumerator;

public enum Logradouro {

	RUA ("Rua", "Tipo de logradouro rua"), 
	AV ("Avenida", "Tipo de logradouro avenida");
	
	private String label;
	private String tipo;
	
	private Logradouro(String label, String tipo) {
		
		this.label = label;
		this.tipo = tipo;
		
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
