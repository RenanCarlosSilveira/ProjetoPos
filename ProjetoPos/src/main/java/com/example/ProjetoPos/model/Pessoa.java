package com.example.ProjetoPos.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PERSON")
public class Pessoa {

	@Id
	private long id;
	private String name;
	private Date birth;

	public Pessoa() {
	}

	public Pessoa(long id, String name, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.birth = birth;
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

}
