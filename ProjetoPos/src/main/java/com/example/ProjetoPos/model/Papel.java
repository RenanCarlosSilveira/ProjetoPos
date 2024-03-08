package com.example.ProjetoPos.model;

public enum Papel {
	ADMIN("ADMIN"), MANAGER("GESTOR"), NORMAL("NORMAL");

	private String nome;

	Papel(final String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public String getName() {
		return this.name();
	}
}
