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
import br.com.unipe.enumerator.Enderecos;
import br.com.unipe.enumerator.Estados;

@ManagedBean(name = "enderecoBean")
@SessionScoped
public class EnderecoBean extends UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Endereco endereco;
	private Endereco novoEndereco;
	private Usuario usuario;
	private List<SelectItem> listMunicipios;
	private List<SelectItem> listEstados;

	private List<Endereco> listEndereco;
	private List<SelectItem> listCidades;

	private Estados selectEstado;

	private String filtro;

	public EnderecoBean() {

		endereco = new Endereco();
		usuario = new Usuario();
		usuario.setEndereco(endereco);

		listMunicipios = new ArrayList<>();
		listEstados = new ArrayList<>();
		listEndereco = new ArrayList<>();
		listEndereco = Enderecos.INSTANCE.allAdress();

	}

	@PostConstruct
	public void initCidades() {
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

	public void filtrarTabela() {
		listEndereco = new ArrayList<>();
		for (Endereco e : Enderecos.INSTANCE.allAdress()) {
			if (e.getCep().contains(filtro)) {
				listEndereco.add(e);
			}
		}
	}

	public String carregarDetalhes(Endereco endereco) {
		this.endereco = endereco;
		return "detalhesEndereco";
	}

	public void carregarDetalhes2(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<SelectItem> getListCidades() {
		return listCidades;
	}

	public void setListCidades(List<SelectItem> listCidades) {
		this.listCidades = listCidades;
	}

	public Estados getSelectEstado() {
		return selectEstado;
	}

	public void setSelectEstado(Estados selectEstado) {
		this.selectEstado = selectEstado;
	}

	public List<SelectItem> getListEstados() {
		return listEstados;
	}

	public void setListEstados(List<SelectItem> listEstados) {
		this.listEstados = listEstados;
	}

	public List<SelectItem> getListMunicipios() {
		return listMunicipios;
	}

	public void setListMunicipios(List<SelectItem> listMunicipios) {
		this.listMunicipios = listMunicipios;
	}

	public List<Endereco> getListEndereco() {
		return listEndereco;
	}

	public String prepararCadastro() {
		endereco = new Endereco();
		return "cadastroEndereco";
	}

	public String prepararList() {
		return "";
	}

	public String adicionarEndereco() {
		Enderecos.INSTANCE.addAdress(endereco);
		listEndereco = Enderecos.INSTANCE.allAdress();
		return "listarEnderecos.jsf";
	}

	public String listarEnderecos() {
		listEndereco = Enderecos.INSTANCE.allAdress();
		return "listarEnderecos.jsf";
	}

	public String atualizarEndereco() {
		Enderecos.INSTANCE.updateAdress(endereco, novoEndereco);
		listEndereco = Enderecos.INSTANCE.allAdress();
		return "listarEnderecos.jsf";
	}

	public String removerEndereco() {
		Enderecos.INSTANCE.removeAdress(endereco);
		listEndereco = Enderecos.INSTANCE.allAdress();
		return "listarEnderecos.jsf";
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public void setListEndereco(List<Endereco> listEndereco) {
		this.listEndereco = listEndereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}