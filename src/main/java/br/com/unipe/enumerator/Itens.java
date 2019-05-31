package br.com.unipe.enumerator;

import java.util.ArrayList;
import java.util.List;

import br.com.unipe.entidade.Item;

public enum Itens {

	INSTANCE;

	private List<Item> listItens;
	private String label;

	private Itens() {

		listItens = new ArrayList<>();
	}

	public List<Item> getListItens() {
		return listItens;
	}

	public void setListItens(List<Item> listItens) {
		this.listItens = listItens;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void addItem(Item item) {

		if (item != null && !listItens.contains(item)) {
			listItens.add(item);

		}
	}

	public List<Item> allItens() {
		return listItens;
	}

	public void updateItem(int id, Item item) {
		for (int i = 0; i < listItens.size(); i++)
			if (item.equals(listItens.get(i)) && item.getId() != (id))
				;
		listItens.set(id, item);

	}

	public void removeItem(Item item) {
		if (item != null && listItens.contains(item)) {
			listItens.remove(item);
		}
	}

}
