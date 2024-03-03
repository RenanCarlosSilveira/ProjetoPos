package com.example.ProjetoPos.model;

public enum Papel {
	ADMIN("ADMIN"), MANAGER("GESTOR"), NORMAL("NORMAL");

	private String papel;

	Papel(String papel) {
		this.papel = papel;
	}

	public String getPapel() {
		return papel;
	}
}
