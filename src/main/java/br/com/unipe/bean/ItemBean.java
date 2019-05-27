package br.com.unipe.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.unipe.entidade.Item;
import br.com.unipe.enumerator.Itens;

@ManagedBean(name = "itemBean")
@SessionScoped
public class ItemBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Item item;

	private Item selectItem;
	private List<Item> listItens;

	private String filtro;
	
	public ItemBean() {
		item = new Item();
		listItens = new ArrayList<>();
		listItens = Itens.INSTANCE.allItens();
	}

	public Item getSelectItem() {
		return selectItem;
	}

	public void setSelectItem(Item selectItem) {
		this.selectItem = selectItem;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String prepararCadastro() {
		item = new Item();
		return "cadastroItem";
	}

	public String prepararList() {
		return "";
	}

	public boolean adicionarItem(Item item) {
		if (item != null && !listItens.contains(item)) {
			return listItens.add(item);
		} else {
			return false;
		}
	}

	public List<Item> allItens() {
		return listItens;
	}

	public boolean atualizarItem(Item item, Item novoItem) {
		for (int i = 0; i < listItens.size(); i++)
			if (item.equals(listItens.get(i)))
				listItens.set(i, novoItem);
		return true;
	}

	public boolean removerItem(Item item) {
		if (item != null && listItens.contains(item)) {
			return listItens.remove(item);
		} else {
			return false;
		}
	}

	public void filtrarTabela() {
		listItens = new ArrayList<>();
		for (Item i : Itens.INSTANCE.allItens()) {
			if (i.getOption().contains(filtro)) {
				listItens.add(i);
			}
		}
	}

	public String carregarDetalhes(Item item) {
		this.item = item;
		return "detalhesItem";
	}

	public void carregarDetalhes2(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}


	public void setListItem(List<Item> listItem) {
		this.listItens = listItem;
	}

	public List<Item> getListItens() {
		return listItens;
	}

	public void setListItens(List<Item> listItens) {
		this.listItens = listItens;
	}

}
