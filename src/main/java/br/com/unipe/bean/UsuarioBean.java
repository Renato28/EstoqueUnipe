package br.com.unipe.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.unipe.dao.UsuarioDaoImpl;
import br.com.unipe.entidade.Endereco;
import br.com.unipe.entidade.Usuario;
import br.com.unipe.enumerator.Cidade;
import br.com.unipe.enumerator.Estado;
import br.com.unipe.enumerator.Sexo;
import br.com.unipe.enumerator.Usuarios;

@Named
@SessionScoped
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Endereco endereco;
	private Estado estado;
	private Cidade cidade;
	private Sexo sexo;

	private List<Usuario> listUsuario = new ArrayList<Usuario>();
	private List<Endereco> listEndereco;
	private List<Estado> listEstado;
	private List<Cidade> listCidade;
	private List<Sexo> listSexo;

	private UsuarioDaoImpl usuarioDaoImpl;

	private String filtro;

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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}

	public List<Endereco> getListEndereco() {
		return listEndereco;
	}

	public void setListEndereco(List<Endereco> listEndereco) {
		this.listEndereco = listEndereco;
	}

	public List<Estado> getListEstado() {
		return listEstado;
	}

	public void setListEstado(List<Estado> listEstado) {
		this.listEstado = listEstado;
	}

	public List<Cidade> getListCidade() {
		return listCidade;
	}

	public void setListCidade(List<Cidade> listCidade) {
		this.listCidade = listCidade;
	}

	public List<Sexo> getListSexo() {
		return listSexo;
	}

	public void setListSexo(List<Sexo> listSexo) {
		this.listSexo = listSexo;
	}

	public UsuarioDaoImpl getUsuarioDaoImpl() {
		return usuarioDaoImpl;
	}

	public void setUsuarioDaoImpl(UsuarioDaoImpl usuarioDaoImpl) {
		this.usuarioDaoImpl = usuarioDaoImpl;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public String adicionarUsuario(Usuario usuario) {
		usuarioDaoImpl.salvar(usuario);
		return "listaUsuario";
	}

	public List<Usuario> getListUsuario() {
		return listUsuario;
	}

	public String atualizarUsuario(Usuario usuario) {
		usuarioDaoImpl.atualizar(usuario);
		return "listaUsuario";
	}
	
	public String excluirUsuario(long id) {
		usuarioDaoImpl.excluir(id);
		return "listaUsuario";
	}

	@PostConstruct
	public void inicializarTabela() {
		usuarioDaoImpl = new UsuarioDaoImpl();
		listUsuario = usuarioDaoImpl.ListUsuario();
	}

	public void filtrarTabela() {
		listUsuario = new ArrayList<>();
		for (Usuario u : Usuarios.INSTANCE.allUsers()) {
			if (u.getNome().contains(filtro)) {
				listUsuario.add(u);
			}
		}
	}

}
