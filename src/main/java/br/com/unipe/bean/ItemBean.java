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
	private Item novoItem;
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

	public String adicionarItem() {
		Itens.INSTANCE.addItem(item);
		listItens = Itens.INSTANCE.allItens();
		return "listarItens";
	}

	public String listarItens() {
		listItens = Itens.INSTANCE.allItens();
		return "listarItens.jsf";
	}

	public String atualizarItem() {
		Itens.INSTANCE.updateItem(item, novoItem);
		listItens = Itens.INSTANCE.allItens();
		return "listarItens.jsf";
	}

	public String removerItem() {
		Itens.INSTANCE.removeItem(item);
		listItens = Itens.INSTANCE.allItens();
		return "listarItens";
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