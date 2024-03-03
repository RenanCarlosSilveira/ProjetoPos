package com.example.ProjetoPos.model;

import java.math.BigDecimal;

public class Produto {

	private long id;
	private String name;
	private BigDecimal value;
	private Area area;
	private long stock;

	public Produto() {
	}

	public Produto(long id, String name, BigDecimal value, Area area, long stock) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.area = area;
		this.stock = stock;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}
