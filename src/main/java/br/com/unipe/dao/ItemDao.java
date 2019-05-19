package br.com.unipe.dao;

import java.util.List;

import br.com.unipe.entidade.Item;

public interface ItemDao {

	void salvar(Item item);

	List<Item> ListItem();

	void atualizar(Item item);

	void excluir(long id);

}
