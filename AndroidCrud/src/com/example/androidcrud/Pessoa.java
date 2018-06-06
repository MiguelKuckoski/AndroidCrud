package com.example.androidcrud;

import java.io.Serializable;

public class Pessoa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8995900905998579082L;
	private String nome;
	private int idade;
	private boolean casada;
	
	public Pessoa ( ) {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public boolean isCasada() {
		return casada;
	}

	public void setCasada(boolean casada) {
		this.casada = casada;
	}


}
