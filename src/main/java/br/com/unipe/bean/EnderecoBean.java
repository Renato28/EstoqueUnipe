package br.com.unipe.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.com.unipe.dao.EnderecoDaoImpl;
import br.com.unipe.entidade.Endereco;
import br.com.unipe.enumerator.Cidades;
import br.com.unipe.enumerator.Enderecos;
import br.com.unipe.enumerator.Estados;
import br.com.unipe.enumerator.Logradouro;

@Named
@SessionScoped
public class EnderecoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Endereco endereco;
	private Logradouro logradouro;
	private Cidades cidade;
	private Estados estado;

	private List<Endereco> listEndereco = new ArrayList<Endereco>();
	private List<Logradouro> listLogradouro;

	private Estados selectEstado;
	private List<SelectItem> listCidade;
	private List<SelectItem> listEstado;
	private EnderecoDaoImpl enderecoDaoImpl;

	private String filtro;

	public EnderecoBean() {
		endereco = new Endereco();
		listCidade = new ArrayList<>();
		listEndereco = new ArrayList<>();
		listEndereco = Enderecos.INSTANCE.allAdress();
	}

	@PostConstruct
	public void initCidade() {
		listCidade = new ArrayList<>();
		for (Cidades c : Cidades.values()) {
			listCidade.add(new SelectItem(c, c.getLabel()));
		}

		listEstado = new ArrayList<>();
		for (Estados e : Estados.values()) {
			listEstado.add(new SelectItem(e, e.getLabel()));
		}
	}

	public void carregarCidades() {
		listCidade = new ArrayList<>();
		for (Cidades cidades : Cidades.values()) {
			if (selectEstado.name().equals(cidades.getEstado()))
				listCidade.add(new SelectItem(cidades, cidades.getLabel()));
		}
	}

	public String prepararCadastro() {
		endereco = new Endereco();
		return "cadastroEndereco";
	}

	public String prepararList() {
		return "";
	}

	public String adicionarEndereco(Endereco endereco) {
		enderecoDaoImpl.salvar(endereco);
		return "listaEndereco";
	}

	public List<Endereco> getListEndereco() {
		return listEndereco;
	}

	public String atualizarEndereco(Endereco endereco) {
		enderecoDaoImpl.atualizar(endereco);
		return "listaEndereco";
	}

	public String excluirEndereco(long id) {
		enderecoDaoImpl.excluir(id);
		return "listaEndereco";
	}

	@PostConstruct
	public void inicializarTela() {
		enderecoDaoImpl = new EnderecoDaoImpl();
		listEndereco = enderecoDaoImpl.ListEndereco();

	}

	public void filtrarTabela() {
		listEndereco = new ArrayList<>();
		for (Endereco e : Enderecos.INSTANCE.allAdress()) {
			if (e.getCep().contains(filtro)) {
				listEndereco.add(e);
			}
		}
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public Cidades getCidade() {
		return cidade;
	}

	public void setCidade(Cidades cidade) {
		this.cidade = cidade;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	public List<Logradouro> getListLogradouro() {
		return listLogradouro;
	}

	public void setListLogradouro(List<Logradouro> listLogradouro) {
		this.listLogradouro = listLogradouro;
	}

	public List<SelectItem> getListCidade() {
		return listCidade;
	}

	public void setListCidade(List<SelectItem> listCidade) {
		this.listCidade = listCidade;
	}

	public List<SelectItem> getListEstado() {
		return listEstado;
	}

	public void setListEstado(List<SelectItem> listEstado) {
		this.listEstado = listEstado;
	}

	public EnderecoDaoImpl getEnderecoDaoImpl() {
		return enderecoDaoImpl;
	}

	public void setEnderecoDaoImpl(EnderecoDaoImpl enderecoDaoImpl) {
		this.enderecoDaoImpl = enderecoDaoImpl;
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
