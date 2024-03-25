package com.example.ProjetoPos.model;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Objects;

import org.apache.tomcat.util.codec.binary.Base64;

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
		id = dto.getId();
		nome = dto.getNome();
		valor = dto.getValor();
		area = Area.valueOf(dto.getArea());
		estoque = dto.getEstoque();
		imagem = StringUtils.isNotEmpty(dto.getImagem())
				? ProjetoPosUtil.getBlobFromBytes(Base64.decodeBase64(dto.getImagem()))
				: null;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public long getValor() {
		return valor;
	}

	public void setValor(final long valor) {
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

	public void setImagem(final Blob imagem) {
		this.imagem = imagem;
	}

	@Transient
	public String getImagemBase64() throws IOException, SQLException {
		if (imagem != null) {
			return Base64.encodeBase64String(ProjetoPosUtil.getBytesFromBlob(imagem));
		} else {
			return "";
		}
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
