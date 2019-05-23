package br.com.unipe.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.unipe.entidade.Endereco;
import br.com.unipe.entidade.Usuario;
import br.com.unipe.enumerator.Sexo;
import br.com.unipe.enumerator.Usuarios;

@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuarios;
	private Endereco endereco;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	private List<SelectItem> listSexos;
	private List<Usuario> listUsuarios;

	private String filtro;

	public UsuarioBean() {
		usuarios = new Usuario();
		listUsuarios = new ArrayList<>();
		listUsuarios = Usuarios.INSTANCE.allUsers();
	}

	public Usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getListUsuarios() {
		return listUsuarios;
	}

	public void setListUsuarios(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}

	public List<SelectItem> getListSexos() {
		return listSexos;
	}

	public void setListSexos(List<SelectItem> listSexos) {
		this.listSexos = listSexos;
	}

	@PostConstruct
	public void initSexo() {
		listSexos = new ArrayList<>();
		for (Sexo s : Sexo.values()) {
			listSexos.add(new SelectItem(s, s.getLabel()));
		}

	}

	public String prepararCadastro() {
		usuarios = new Usuario();
		return "cadastroUsuario";
	}

	public String prepararList() {
		return "";
	}

	public String adicionarUsuario() {
		Usuarios.INSTANCE.addUsers(usuarios);
		listUsuarios = Usuarios.INSTANCE.allUsers();
		return "listarUsuarios";
	}

	public List<Usuario> getListUsuario() {
		return listUsuarios;
	}

	public void filtrarTabela() {
		listUsuarios = new ArrayList<>();
		for (Usuario u : Usuarios.INSTANCE.allUsers()) {
			if (u.getNome().contains(filtro)) {
				listUsuarios.add(u);
			}
		}
	}
	
//	public Date getMaxdate() {
//        Calendar now = Calendar.getInstance();
//        now.add(Calendar.YEAR, +18);
//        return now.getTime();
//    }

	public Usuario getUsuario() {
		return usuarios;
	}

	public void setUsuario(Usuario usuario) {
		this.usuarios = usuario;
	}

	public List<SelectItem> getListSexo() {
		return listSexos;
	}

	public void setListSexo(List<SelectItem> listSexo) {
		this.listSexos = listSexo;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public void setListUsuario(List<Usuario> listusuarios) {
		this.listUsuarios = listusuarios;
	}	

}
