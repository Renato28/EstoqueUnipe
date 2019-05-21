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
import br.com.unipe.enumerator.Cidades;
import br.com.unipe.enumerator.Estados;
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
	private List<SelectItem> listCidades;
	private List<Usuario> listUsuarios;
	

	private Estados selectEstado;
	private List<SelectItem> listEstados;
	private List<SelectItem> listMunicipios;
	
	private List<String> listLogradouros;
	
	private String filtro;
	
	public UsuarioBean() {
		usuarios = new Usuario();
		listMunicipios = new ArrayList<>();
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

	public Estados getSelectEstado() {
		return selectEstado;
	}

	public void setSelectEstado(Estados selectEstado) {
		this.selectEstado = selectEstado;
	}

	public List<SelectItem> getListMunicipios() {
		return listMunicipios;
	}

	public void setListMunicipios(List<SelectItem> listMunicipios) {
		this.listMunicipios = listMunicipios;
	}

	public List<SelectItem> getListSexos() {
		return listSexos;
	}

	public void setListSexos(List<SelectItem> listSexos) {
		this.listSexos = listSexos;
	}

	public List<SelectItem> getListCidades() {
		return listCidades;
	}

	public void setListCidades(List<SelectItem> listCidades) {
		this.listCidades = listCidades;
	}

	public List<SelectItem> getListEstados() {
		return listEstados;
	}

	public void setListEstados(List<SelectItem> listEstados) {
		this.listEstados = listEstados;
	}

	public List<String> getListLogradouros() {
		return listLogradouros;
	}

	public void setListLogradouros(List<String> listLogradouros) {
		this.listLogradouros = listLogradouros;
	}

	@PostConstruct
	public void initSexo() {
		listSexos = new ArrayList<>();
		for (Sexo s : Sexo.values()) {
			listSexos.add(new SelectItem(s, s.getLabel()));
		}

		listCidades = new ArrayList<>();
		for (Cidades c : Cidades.values()) {
			listCidades.add(new SelectItem(c, c.getLabel()));
		}

		listEstados = new ArrayList<>();
		for (Estados e : Estados.values()) {
			listCidades.add(new SelectItem(e, e.getLabel()));
		}
	}

	public void carregarMunicipios() {
		listMunicipios = new ArrayList<>();
		for (Cidades cidades : Cidades.values()) {
			if (selectEstado.name().equals(cidades.getEstado()))
				listMunicipios.add(new SelectItem(cidades, cidades.getLabel()));
		}
	}

	public String prepararCadastro() {
		usuarios = new Usuario();
		return "cadastroUsuario";
	}

	public String prepararList() {
		return "";
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

	public Usuario getUsuario() {
		return usuarios;
	}

	public void setUsuario(Usuario usuario) {
		this.usuarios = usuario;
	}

	public List<SelectItem> getListEstado() {
		return listEstados;
	}

	public void setListEstado(List<SelectItem> listEstado) {
		this.listEstados = listEstado;
	}

	public List<SelectItem> getListCidade() {
		return listCidades;
	}

	public void setListCidade(List<SelectItem> listCidade) {
		this.listCidades = listCidade;
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
