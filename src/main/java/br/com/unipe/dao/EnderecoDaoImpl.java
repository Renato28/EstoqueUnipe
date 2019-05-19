package br.com.unipe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.unipe.entidade.Endereco;

public class EnderecoDaoImpl implements EnderecoDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void salvar(Endereco endereco) {

		em.persist(endereco);
	}

	@Override
	public List<Endereco> ListEndereco(){

		return em.createQuery("select from Endereco e", Endereco.class).getResultList();
	}

	@Override
	public void atualizar(Endereco endereco) {

		em.merge(endereco);
	}

	@Override
	public void excluir(long id) {

		em.remove(em.getReference(Endereco.class, id));
	}

}
