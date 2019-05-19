package br.com.unipe.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import br.com.unipe.enumerator.TipoItem;

@Entity
@Table(name = "Item")
public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	@NotEmpty
	private String nome;
	@Column(nullable = false)
	@NotEmpty
	private Double quantidade;
	@Column(nullable = false)
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
