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

	public boolean addUsers(Usuario usuario) {
		if (usuario != null && !listUsuarios.contains(usuario)) {
			return listUsuarios.add(usuario);
		} else {
			return false;
		}
	}

	public List<Usuario> allUsers() {
		return listUsuarios;
	}

	public boolean updateUsers(Usuario usuario, Usuario novoUsuario) {
		for (int i = 0; i < listUsuarios.size(); i++)
			if (usuario.equals(listUsuarios.get(i)))
				listUsuarios.set(i, novoUsuario);
		return true;
	}

	public boolean removeUser(Usuario usuario) {
		if (usuario != null && listUsuarios.contains(usuario)) {
			return listUsuarios.remove(usuario);
		} else {
			return false;
		}
	}

}