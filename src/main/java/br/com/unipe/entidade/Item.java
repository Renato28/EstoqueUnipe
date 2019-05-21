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
	private TipoItem item;

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
		return item;
	}

	public void setItem(TipoItem item) {
		this.item = item;
	}

}
