package com.example.ProjetoPos.model;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "PRODUTO")
public class Produto {

	private long id;
	private String nome;
	private BigDecimal valor;
	private Area area;
	private long estoque;
	private Blob imagem;

	public Produto() {
	}

	public Produto(final String nome, final BigDecimal valor, final Area area, final long estoque) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.area = area;
		this.estoque = estoque;
	}

	public Produto(final String nome, final BigDecimal valor, final Area area, final long estoque, final Blob imagem) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.area = area;
		this.estoque = estoque;
		this.imagem = imagem;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	@Column(name = "nome")
	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	@Column(name = "valor")
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(final BigDecimal valor) {
		this.valor = valor;
	}

	@Column(name = "estoque")
	public long getEstoque() {
		return estoque;
	}

	public void setEstoque(final long estoque) {
		this.estoque = estoque;
	}

	@Column(name = "area")
	public Area getArea() {
		return area;
	}

	public void setArea(final Area area) {
		this.area = area;
	}

	@Column(name = "imagem")
	public Blob getImagem() {
		return imagem;
	}

	@Transient
	public String getImagemBase64() throws IOException, SQLException {
		if (imagem != null) {
			return Base64.getEncoder().encodeToString(imagem.getBinaryStream().readAllBytes());
		} else {
			return "";
		}
	}

	public void setImagem(Blob imagem) {
		this.imagem = imagem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
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
		return id == other.id && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + "]";
	}
}
