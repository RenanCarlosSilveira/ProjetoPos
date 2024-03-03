package com.example.ProjetoPos.model;

public class Usuario {

	private long id;
	private String login;
	private String password;
	private Papel role;
	private Pessoa person;

	public Usuario() {
	}

	public Usuario(long id, String login, String password, Papel role, Pessoa person) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
		this.person = person;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Papel getRole() {
		return role;
	}

	public void setRole(Papel role) {
		this.role = role;
	}

	public Pessoa getPerson() {
		return person;
	}

	public void setPerson(Pessoa person) {
		this.person = person;
	}

}
