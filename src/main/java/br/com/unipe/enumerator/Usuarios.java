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

		if (usuario != null && !listUsuarios.contains(usuario)) {
			listUsuarios.add(usuario);

		}
	}

	public List<Usuario> allUsers() {
		return listUsuarios;
	}

	public void updateUsers(int id, Usuario usuario) {
		for (int i = 0; i < listUsuarios.size(); i++)
			if (usuario.equals(listUsuarios.get(i)) && usuario.getId() != (id))
				;
		listUsuarios.set(id, usuario);

	}

	public void removeUser(Usuario usuario) {
		if (usuario != null && listUsuarios.contains(usuario)) {
			listUsuarios.remove(usuario);
		}
	}

}