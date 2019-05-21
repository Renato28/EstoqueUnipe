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
	private Usuario usuario;
	private Endereco endereco;
	private Estados estado;
	private Cidades cidade;
	private Sexo sexo;

	private List<Usuario> listUsuario = new ArrayList<Usuario>();
	private List<Endereco> listEndereco;

	private Estados selectEstado;
	private List<SelectItem> listEstado;
	private List<SelectItem> listCidade;
	private List<SelectItem> listSexo;


	private String filtro;

	public UsuarioBean() {
		usuario = new Usuario();
		listCidade = new ArrayList<>();
		listUsuario = new ArrayList<>();
		listUsuario = Usuarios.INSTANCE.allUsers();
	}

	@PostConstruct
	public void initSexo() {
		listSexo = new ArrayList<>();
		for (Sexo s : Sexo.values()) {
			listSexo.add(new SelectItem(s, s.getLabel()));
		}

		listCidade = new ArrayList<>();
		for (Cidades c : Cidades.values()) {
			listCidade.add(new SelectItem(c, c.getLabel()));
		}

		listEstado = new ArrayList<>();
		for (Estados e : Estados.values()) {
			listCidade.add(new SelectItem(e, e.getLabel()));
		}
	}

	public void carregarCidades() {
		listCidade = new ArrayList<>();
		for (Cidades cidades : Cidades.values()) {
			if (selectEstado.name().equals(cidades.getEstado()))
				listCidade.add(new SelectItem(cidade, cidade.getLabel()));
		}
	}

	public String prepararCadastro() {
		usuario = new Usuario();
		return "cadastroUsuario";
	}

	public String prepararList() {
		return "";
	}

	public List<Usuario> getListUsuario() {
		return listUsuario;
	}


	public void filtrarTabela() {
		listUsuario = new ArrayList<>();
		for (Usuario u : Usuarios.INSTANCE.allUsers()) {
			if (u.getNome().contains(filtro)) {
				listUsuario.add(u);
			}
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	public Cidades getCidade() {
		return cidade;
	}

	public void setCidade(Cidades cidade) {
		this.cidade = cidade;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public List<Endereco> getListEndereco() {
		return listEndereco;
	}

	public void setListEndereco(List<Endereco> listEndereco) {
		this.listEndereco = listEndereco;
	}

	public List<SelectItem> getListEstado() {
		return listEstado;
	}

	public void setListEstado(List<SelectItem> listEstado) {
		this.listEstado = listEstado;
	}

	public List<SelectItem> getListCidade() {
		return listCidade;
	}

	public void setListCidade(List<SelectItem> listCidade) {
		this.listCidade = listCidade;
	}

	public List<SelectItem> getListSexo() {
		return listSexo;
	}

	public void setListSexo(List<SelectItem> listSexo) {
		this.listSexo = listSexo;
	}


	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}

}
