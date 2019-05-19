package br.com.unipe.enumerator;

import java.util.ArrayList;
import java.util.List;

import br.com.unipe.entidade.Item;

public enum Itens {

	INSTANCE;

	private List<Item> listItens;

	private Itens() {

		listItens = new ArrayList<>();
	}

	public void addItem(Item item) {
		listItens.add(item);
	}
	
	public List<Item> allItens(){
		return listItens;
	}
}
