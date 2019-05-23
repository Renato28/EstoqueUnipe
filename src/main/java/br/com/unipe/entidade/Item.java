package br.com.unipe.entidade;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.unipe.enumerator.TipoItem;


public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@NotEmpty
	private String nome;
	@NotEmpty
	private Double quantidade;
	@NotEmpty
	private TipoItem Tipoitem;
	private String option;
	
	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public TipoItem getItem() {
		return Tipoitem;
	}

	public void setItem(TipoItem item) {
		this.Tipoitem = item;
	}

}
