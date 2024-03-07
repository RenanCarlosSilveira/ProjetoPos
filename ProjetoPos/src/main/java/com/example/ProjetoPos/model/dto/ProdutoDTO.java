/**
 *
 */
package com.example.ProjetoPos.model.dto;

import java.io.IOException;
import java.sql.SQLException;
import com.example.ProjetoPos.model.Produto;
import io.micrometer.common.util.StringUtils;

/**
 * @author <a href="mailto:renan.silveira@unoesc.edu.br">Renan Silveira</a>
 * @since 07/03/2024
 */
public class ProdutoDTO {

	private long id;
	private String nome;
	private long valor;
	private String area;
	private long estoque;
	private String imagem;

	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(final long id, final String nome, final long valor, final String area, final long estoque, final String imagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.area = area;
		this.estoque = estoque;
		this.imagem = imagem;
	}

	public ProdutoDTO(final Produto produto) throws IOException, SQLException {
		super();
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.valor = produto.getValor();
		this.area = produto.getArea().getNome();
		this.estoque = produto.getEstoque();
		this.imagem = produto.getImagem() != null ? produto.getImagemBase64() : null;
	}

	public long getId() {
		return this.id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public long getValor() {
		return this.valor;
	}

	public void setValor(final long valor) {
		this.valor = valor;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(final String area) {
		this.area = area;
	}

	public long getEstoque() {
		return this.estoque;
	}

	public void setEstoque(final long estoque) {
		this.estoque = estoque;
	}

	public String getImagem() {
		return this.imagem;
	}

	public void setImagem(final String imagem) {
		this.imagem = imagem;
	}

	public boolean isValid() {
		return StringUtils.isNotEmpty(this.nome) && this.estoque > 0 && this.valor > 0 && this.area != null;
	}

}
