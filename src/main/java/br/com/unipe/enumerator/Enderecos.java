package br.com.unipe.enumerator;

import java.util.ArrayList;
import java.util.List;

import br.com.unipe.entidade.Endereco;

public enum Enderecos {

	INSTANCE;

	private List<Endereco> listEnderecos;

	private Enderecos() {

		listEnderecos = new ArrayList<>();
	}

	public void addAdress(Endereco endereco) {
		listEnderecos.add(endereco);
	}
	
	public List<Endereco> allAdress(){
		return listEnderecos;
	}
	
}
