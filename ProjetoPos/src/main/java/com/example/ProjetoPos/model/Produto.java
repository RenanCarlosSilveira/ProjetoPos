package com.example.ProjetoPos.model;

import java.math.BigDecimal;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto {

	private long id;
	private String nome;
	private BigDecimal valor;
	private Area area;
	private long estoque;

	public Produto() {}

	public Produto(final String nome, final BigDecimal valor, final Area area, final long estoque) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.area = area;
		this.estoque = estoque;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	public long getId() {
		return this.id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	@Column(name = "nome")
	public String getNome() {
		return this.nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	@Column(name = "valor")
	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(final BigDecimal valor) {
		this.valor = valor;
	}

	@Column(name = "estoque")
	public long getEstoque() {
		return this.estoque;
	}

	public void setEstoque(final long estoque) {
		this.estoque = estoque;
	}

	@Column(name = "area")
	public Area getArea() {
		return this.area;
	}

	public void setArea(final Area area) {
		this.area = area;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.nome);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		final Produto other = (Produto) obj;
		return this.id == other.id && Objects.equals(this.nome, other.nome);
	}

}
