package br.com.unipe.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.unipe.entidade.Endereco;
import br.com.unipe.entidade.Pessoa;
import br.com.unipe.entidade.Usuario;
import br.com.unipe.enumerator.Enderecos;
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

	private Usuario usuario;
	private Usuario novoUsuario;
	private Endereco endereco;
	private Pessoa pessoa;

	private List<Endereco> listEnderecos;
	private List<TipoPessoa> listTipoPessoas;

	private Estados selectEstado;
	private List<SelectItem> listCidades;
	private List<SelectItem> listMunicipios;
	private List<SelectItem> listEstados;

	private List<SelectItem> listSexos;
	private List<SelectItem> listPessoas;

	private List<Usuario> listUsuarios;

	private String filtro;
	private Boolean isRenderiza = false;

	public UsuarioBean() {

		usuario = new Usuario();
		endereco = new Endereco();
		pessoa = new Pessoa();
		usuario.setEndereco(endereco);
		listEnderecos = new ArrayList<>();
		listMunicipios = new ArrayList<>();
		listEstados = new ArrayList<>();
		listUsuarios = new ArrayList<>();
		listPessoas = new ArrayList<>();
		listSexos = new ArrayList<>();
		listUsuarios = Usuarios.INSTANCE.allUsers();
		listEnderecos = Enderecos.INSTANCE.allAdress();
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
		return usuario;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuario = usuarios;
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

	public List<Endereco> getListEnderecos() {
		return listEnderecos;
	}

	public void setListEnderecos(List<Endereco> listEnderecos) {
		this.listEnderecos = listEnderecos;
	}

	public List<TipoPessoa> getListTipoPessoas() {
		return listTipoPessoas;
	}

	public void setListTipoPessoas(List<TipoPessoa> listTipoPessoas) {
		this.listTipoPessoas = listTipoPessoas;
	}

	public List<SelectItem> getListCidades() {
		return listCidades;
	}

	public void setListCidades(List<SelectItem> listCidades) {
		this.listCidades = listCidades;
	}

	public String prepararCadastro() {
		usuario = new Usuario();
		return "cadastroUsuario";
	}

	public String prepararList() {
		return "";
	}

	@PostConstruct
	public void initSexo() {
		listSexos = new ArrayList<>();
		for (Sexo sexo : Sexo.values()) {
			listSexos.add(new SelectItem(sexo, sexo.getLabel()));
		}
	}

	public String adicionarUsuario() {
		Usuarios.INSTANCE.addUsers(usuario);
		listUsuarios = Usuarios.INSTANCE.allUsers();
		return "listarUsuarios.jsf";
	}

	public String listarUsuarios() {
		listUsuarios = Usuarios.INSTANCE.allUsers();
		return "listarUsuarios.jsf";
	}

	public String atualizarUsuario() {
		Usuarios.INSTANCE.updateUsers(usuario, novoUsuario);
		listUsuarios = Usuarios.INSTANCE.allUsers();
		return "listarUsuarios.jsf";
	}

	public String removerUsuario() {
		Usuarios.INSTANCE.removeUser(usuario);
		listUsuarios = Usuarios.INSTANCE.allUsers();
		return "listarUsuarios.jsf";
	}

	public void buscarCep(String cep) {
		for (Endereco endereco : listEnderecos) {

			if (endereco.getCep().equals(usuario.getEndereco().getCep())) {

				usuario.setEndereco(endereco);
			}
		}
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
		this.usuario = usuario;
		return "detalhesUsuario";
	}

	public void carregarDetalhes2(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Boolean getIsRenderiza() {
		return isRenderiza;
	}

	public void setIsRenderiza(Boolean isRenderiza) {
		this.isRenderiza = isRenderiza;
	}

	public void renderizar() {
		if (pessoa.getTipo().equals("J")) {
			isRenderiza = true;
		} else {
			isRenderiza = false;
		}
	}
}