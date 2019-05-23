package br.com.unipe.entidade;

import java.io.Serializable;

public class Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String PESSOA_FISICA = "F�sica";
	private static final String PESSOA_JURIDICA = "Jur�dica";

	public static String getPessoaFisica() {
		return PESSOA_FISICA;
	}

	public static String getPessoaJuridica() {
		return PESSOA_JURIDICA;
	}

}
