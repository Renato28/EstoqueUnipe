package br.com.unipe.dao;

import java.util.List;

import br.com.unipe.entidade.Usuario;

public interface UsuarioDao {

	void salvar(Usuario usuario);

	List<Usuario> ListUsuario();

	void atualizar(Usuario usuario);

	void excluir(long id);
}
