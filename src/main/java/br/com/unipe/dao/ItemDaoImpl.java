package br.com.unipe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.unipe.entidade.Item;

public class ItemDaoImpl implements ItemDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void salvar(Item item) {

		em.persist(item);
	}

	@Override
	public List<Item> ListItem() {

		return em.createQuery("select from Item i", Item.class).getResultList();
	}

	@Override
	public void atualizar(Item item) {

		em.merge(item);
	}

	@Override
	public void excluir(long id) {

		em.remove(em.getReference(Item.class, id));
	}

}
