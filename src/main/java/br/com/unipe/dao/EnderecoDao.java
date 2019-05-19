package br.com.unipe.dao;

import java.util.List;

import br.com.unipe.entidade.Endereco;


public interface EnderecoDao {

	void salvar(Endereco endereco);
	List<Endereco> ListEndereco();
	void atualizar(Endereco endereco);
	void excluir(long id);
	
}
