package com.example.ProjetoPos.model;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Objects;
import com.example.ProjetoPos.model.dto.ProdutoDTO;
import com.example.ProjetoPos.util.ProjetoPosUtil;
import io.micrometer.common.util.StringUtils;
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
	private long valor;
	private Area area;
	private long estoque;
	private Blob imagem;

	public Produto() {
	}

	public Produto(final String nome, final long valor, final Area area, final long estoque) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.area = area;
		this.estoque = estoque;
	}

	public Produto(final ProdutoDTO dto) {
		super();
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.valor = dto.getValor();
		this.area = Area.valueOf(dto.getArea());
		this.estoque = dto.getEstoque();
		this.imagem = StringUtils.isNotEmpty(dto.getImagem()) ? ProjetoPosUtil.getBlobFromBytes(dto.getImagem().getBytes()) : null;
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
	public long getValor() {
		return this.valor;
	}

	public void setValor(final long valor) {
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

	@Column(name = "imagem")
	public Blob getImagem() {
		return this.imagem;
	}

	public void setImagem(final Blob imagem) {
		this.imagem = imagem;
	}

	@Transient
	public String getImagemBase64() throws IOException, SQLException {
		if (this.imagem != null) {
			return Base64.getEncoder().encodeToString(ProjetoPosUtil.getBytesFromBlob(this.imagem));
		} else {
			return "";
		}
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

	@Override
	public String toString() {
		return "Produto [id=" + this.id + ", nome=" + this.nome + "]";
	}
}
