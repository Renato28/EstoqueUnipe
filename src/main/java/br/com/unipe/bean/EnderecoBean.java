package br.com.unipe.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.unipe.entidade.Endereco;
import br.com.unipe.enumerator.Enderecos;

@ManagedBean(name = "enderecoBean")
@SessionScoped
public class EnderecoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Endereco endereco;

	private List<Endereco> listEndereco;

	private String filtro;

	public EnderecoBean() {
		endereco = new Endereco();
		listEndereco = new ArrayList<>();
		listEndereco = Enderecos.INSTANCE.allAdress();

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
