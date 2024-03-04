package com.example.ProjetoPos.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PESSOA")
public class Pessoa {

	private long id;
	private String nome;
	@DateTimeFormat(pattern = "dd/MM/yyyy") private Date nascimento;

	public Pessoa() {}

	public Pessoa(final long id, final String nome, final Date nascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
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

	@Column(name = "nascimento")
	public Date getNascimento() {
		return this.nascimento;
	}

	public void setNascimento(final Date nascimento) {
		this.nascimento = nascimento;
	}

}
