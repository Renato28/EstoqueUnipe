package br.com.unipe.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.unipe.dao.EnderecoDaoImpl;
import br.com.unipe.entidade.Endereco;
import br.com.unipe.enumerator.Cidade;
import br.com.unipe.enumerator.Enderecos;
import br.com.unipe.enumerator.Estado;
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
	private Cidade cidade;
	private Estado estado;

	private List<Endereco> listEndereco = new ArrayList<Endereco>();
	private List<Logradouro> listLogradouro;
	private List<Cidade> listCidade;
	private List<Estado> listEstado;
	private EnderecoDaoImpl enderecoDaoImpl;

	private String filtro;

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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void setListEndereco(List<Endereco> listEndereco) {
		this.listEndereco = listEndereco;
	}

	public List<Logradouro> getListLogradouro() {
		return listLogradouro;
	}

	public void setListLogradouro(List<Logradouro> listLogradouro) {
		this.listLogradouro = listLogradouro;
	}

	public List<Cidade> getListCidade() {
		return listCidade;
	}

	public void setListCidade(List<Cidade> listCidade) {
		this.listCidade = listCidade;
	}

	public List<Estado> getListEstado() {
		return listEstado;
	}

	public void setListEstado(List<Estado> listEstado) {
		this.listEstado = listEstado;
	}

	public EnderecoDaoImpl getEnderecoDao() {
		return enderecoDaoImpl;
	}

	public void setEnderecoDao(EnderecoDaoImpl enderecoDaoImpl) {
		this.enderecoDaoImpl = enderecoDaoImpl;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
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

}
