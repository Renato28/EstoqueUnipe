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

		if (endereco != null && !listEnderecos.contains(endereco)) {
			listEnderecos.add(endereco);

		}
	}

	public List<Endereco> allAdress() {
		return listEnderecos;
	}

	public void updateAdress(int id, Endereco endereco) {
		for (int i = 0; i < listEnderecos.size(); i++)
			if (endereco.equals(listEnderecos.get(i)) && endereco.getId() != (id))
				;
		listEnderecos.set(id, endereco);

	}

	public void removeAdress(Endereco endereco) {
		if (endereco != null && listEnderecos.contains(endereco)) {
			listEnderecos.remove(endereco);
		}
	}

}
