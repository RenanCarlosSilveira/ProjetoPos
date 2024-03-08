package com.example.ProjetoPos.model;

public enum Area {
	COZINHA("COZINHA"), SALA("SALA"), BANHEIRO("BANHEIRO"), AUTO("AUTO"), QUARTO("QUARTO");

	private String nome;

	Area(final String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public String getName() {
		return this.name();
	}
}

