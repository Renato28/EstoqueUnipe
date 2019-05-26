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

	public boolean addItem(Item item) {
		if (item != null && !listItens.contains(item)) {
			return listItens.add(item);
		} else {
			return false;
		}
	}

	public List<Item> allItens() {
		return listItens;
	}

	public boolean updateItem(Item item, Item novoItem) {
		for (int i = 0; i < listItens.size(); i++)
			if (item.equals(listItens.get(i)))
				listItens.set(i, novoItem);
		return true;
	}

	public boolean removeItem(Item item) {
		if (item != null && listItens.contains(item)) {
			return listItens.remove(item);
		} else {
			return false;
		}
	}

}
