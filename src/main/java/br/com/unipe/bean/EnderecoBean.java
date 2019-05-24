package br.com.unipe.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.unipe.entidade.Endereco;
import br.com.unipe.enumerator.Municipios;
import br.com.unipe.enumerator.Enderecos;
import br.com.unipe.enumerator.Estados;

@ManagedBean(name = "enderecoBean")
@SessionScoped
public class EnderecoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Endereco endereco;
	private List<Endereco> listEndereco;
	private List<SelectItem> listCidades;
	private List<String> listLogradouros;

	public List<String> getListLogradouros() {
		return listLogradouros;
	}

	public void setListLogradouros(List<String> listLogradouros) {
		this.listLogradouros = listLogradouros;
	}

	private Estados selectEstado;
	private List<SelectItem> listEstados;
	private List<SelectItem> listMunicipios;

	private String filtro;

	public EnderecoBean() {

		endereco = new Endereco();
		listEndereco = new ArrayList<>();
		listMunicipios = new ArrayList<>();
		listEndereco = Enderecos.INSTANCE.allAdress();

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

	public String prepararCadastro() {
		endereco = new Endereco();
		return "cadastroEndereco";
	}

	public String prepararList() {
		return "";
	}

	public String adicionarEndereco() {
		Enderecos.INSTANCE.addAdress(endereco);
		return "listarEnderecos";
	}

	public List<Endereco> getListEndereco() {
		return listEndereco;
	}

	public void initCidades() {
		listCidades = new ArrayList<>();
		for (Municipios cidades : Municipios.values()) {
			listCidades.add(new SelectItem(cidades, cidades.getLabel()));
		}

		listEstados = new ArrayList<>();
		for (Estados e : Estados.values()) {
			listCidades.add(new SelectItem(e, e.getLabel()));
		}
	}

	public void carregarMunicipios() {
		listMunicipios = new ArrayList<>();
		for (Municipios cidades : Municipios.values()) {
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
}
