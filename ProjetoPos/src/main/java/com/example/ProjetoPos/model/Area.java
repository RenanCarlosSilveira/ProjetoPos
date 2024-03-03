package com.example.ProjetoPos.model;

public enum Area {
	COZINHA("COZINHA"), SALA("SALA"), BANHEIRO("BANHEIRO"), AUTO("AUTO"), QUARTO("QUARTO");

	private String area;

	Area(String area) {
		this.area = area;
	}

	public String getArea() {
		return area;
	}
}
