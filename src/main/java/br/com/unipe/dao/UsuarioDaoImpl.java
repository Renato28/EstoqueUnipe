package br.com.unipe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.unipe.entidade.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void salvar(Usuario usuario) {
		em.persist(usuario);
	}

	@Override
	public List<Usuario> ListUsuario() {

		return em.createQuery("select from Usuario u", Usuario.class).getResultList();
	}

	@Override
	public void atualizar(Usuario usuario) {
		em.merge(usuario);
	}

	@Override
	public void excluir(long id) {
		em.remove(em.getReference(Usuario.class, id));
	}

}
