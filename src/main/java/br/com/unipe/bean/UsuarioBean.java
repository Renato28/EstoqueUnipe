package br.com.unipe.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import br.com.unipe.enumerator.TipoPessoa;
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
	
	private List<String> listNomes;
	private List<String> listUsernames;
	private List<String> listPasswords;
	private List<Endereco> listEnderecos;
	private List<String> listEmails;
	private List<Date> listDataNascimento;
	private List<TipoPessoa> listTipoPessoas;
	private List<Integer> listCpfs;
	private List<Integer> listCnpjs;

	private Estados selectEstado;
	private List<SelectItem> listCidades;
	private List<SelectItem> listMunicipios;
	private List<SelectItem> listEstados;

	private List<SelectItem> listSexos;
	private List<SelectItem> listPessoas;

	private List<Usuario> listUsuarios;

	private String filtro;

	public UsuarioBean() {

		usuarios = new Usuario();
		listUsuarios = new ArrayList<>();
		listUsuarios = Usuarios.INSTANCE.allUsers();
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

	public List<SelectItem> getListEstados() {
		return listEstados;
	}

	public void setListEstados(List<SelectItem> listEstados) {
		this.listEstados = listEstados;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<SelectItem> getListPessoas() {
		return listPessoas;
	}

	public void setListPessoas(List<SelectItem> listPessoas) {
		this.listPessoas = listPessoas;
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
	
	public List<String> getListNomes() {
		return listNomes;
	}

	public void setListNomes(List<String> listNomes) {
		this.listNomes = listNomes;
	}

	public List<String> getListUsernames() {
		return listUsernames;
	}

	public void setListUsernames(List<String> listUsernames) {
		this.listUsernames = listUsernames;
	}

	public List<String> getListPasswords() {
		return listPasswords;
	}

	public void setListPasswords(List<String> listPasswords) {
		this.listPasswords = listPasswords;
	}

	public List<Endereco> getListEnderecos() {
		return listEnderecos;
	}

	public void setListEnderecos(List<Endereco> listEnderecos) {
		this.listEnderecos = listEnderecos;
	}

	public List<String> getListEmails() {
		return listEmails;
	}

	public void setListEmails(List<String> listEmails) {
		this.listEmails = listEmails;
	}

	public List<Date> getListDataNascimento() {
		return listDataNascimento;
	}

	public void setListDataNascimento(List<Date> listDataNascimento) {
		this.listDataNascimento = listDataNascimento;
	}

	public List<TipoPessoa> getListTipoPessoas() {
		return listTipoPessoas;
	}

	public void setListTipoPessoas(List<TipoPessoa> listTipoPessoas) {
		this.listTipoPessoas = listTipoPessoas;
	}

	public List<Integer> getListCpfs() {
		return listCpfs;
	}

	public void setListCpfs(List<Integer> listCpfs) {
		this.listCpfs = listCpfs;
	}

	public List<Integer> getListCnpjs() {
		return listCnpjs;
	}

	public void setListCnpjs(List<Integer> listCnpjs) {
		this.listCnpjs = listCnpjs;
	}

	public List<SelectItem> getListCidades() {
		return listCidades;
	}

	public void setListCidades(List<SelectItem> listCidades) {
		this.listCidades = listCidades;
	}

	@PostConstruct
	public void initSexo() {
		listSexos = new ArrayList<>();
		for (Sexo s : Sexo.values()) {
			listSexos.add(new SelectItem(s, s.getLabel()));
		}

		listCidades = new ArrayList<>();
		for (Cidades cidades : Cidades.values()) {
			listCidades.add(new SelectItem(cidades, cidades.getLabel()));
		}

		listEstados = new ArrayList<>();
		for (Estados estados : Estados.values()) {
			listEstados.add(new SelectItem(estados, estados.getLabel()));
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

	public String carregarDetalhes(Usuario usuario) {
		this.usuarios = usuario;
		return "detalhesUsuario";
	}

	public void carregarDetalhes2(Usuario usuario) {
		this.usuarios = usuario;
	}

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
