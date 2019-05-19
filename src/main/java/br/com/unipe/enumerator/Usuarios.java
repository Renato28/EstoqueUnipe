package br.com.unipe.enumerator;

import java.util.ArrayList;
import java.util.List;

import br.com.unipe.entidade.Usuario;

public enum Usuarios {

	INSTANCE;

	private List<Usuario> listUsuarios;

	private Usuarios() {

		listUsuarios = new ArrayList<>();
	}

	public void addUsers(Usuario usuario) {
		listUsuarios.add(usuario);
	}

	public List<Usuario> allUsers() {
		return listUsuarios;
	}
}
