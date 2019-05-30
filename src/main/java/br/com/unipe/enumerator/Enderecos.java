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

	public boolean addAdress(Endereco endereco) {
		if (endereco != null && !listEnderecos.contains(endereco)) {
			return listEnderecos.add(endereco);
		} else {
			return false;
		}
	}

	public List<Endereco> allAdress() {
		return listEnderecos;
	}

	public boolean updateAdress(Endereco endereco, Endereco novoEndereco) {
		for (int i = 0; i < listEnderecos.size(); i++)
			if (endereco.getCep().equals(listEnderecos.get(i)))
				listEnderecos.set(i, novoEndereco);
		return true;

	}

	public boolean removeAdress(Endereco endereco) {
		if (endereco != null && listEnderecos.contains(endereco)) {
			return listEnderecos.remove(endereco);
		} else {
			return false;
		}
	}

}
