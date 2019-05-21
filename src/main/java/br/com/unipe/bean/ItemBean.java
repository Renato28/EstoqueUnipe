package br.com.unipe.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.unipe.entidade.Item;
import br.com.unipe.enumerator.Itens;
import br.com.unipe.enumerator.TipoItem;

@ManagedBean(name = "itemBean")
@SessionScoped
public class ItemBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Item item;
	private TipoItem tipoItem;

	private Item selectItem;
	private List<Item> listItem;

	private String filtro;

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

	public ItemBean() {
		item = new Item();
		listItem = new ArrayList<>();
		listItem = Itens.INSTANCE.allItens();
	}

	public String prepararCadastro() {
		item = new Item();
		return "cadastroItem";
	}

	public String prepararList() {
		return "";
	}

	public List<Item> getListItem() {
		return listItem;
	}

	public void filtrarTabela() {
		listItem = new ArrayList<>();
		for (Item i : Itens.INSTANCE.allItens()) {
			if (i.getItem().contains(filtro)) {
				listItem.add(i);
			}
		}
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public TipoItem getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}

	public void setListItem(List<Item> listItem) {
		this.listItem = listItem;
	}

}
