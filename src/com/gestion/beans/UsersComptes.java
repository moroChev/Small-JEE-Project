package com.gestion.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users_comptes")
public class UsersComptes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_User")
	private int id_user;
	
	@Column(name="Login")
	private String login;
	
	@Column(name="Password")
	private String password;

	@Column(name="Role")
	private String role;
	
	public UsersComptes(String login, String password, String role) {
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	public UsersComptes() {}
	
	@Override
	public String toString() {
		return "UsersComptes [id_user=" + id_user + ", login=" + login + ", password=" + password + ", role=" + role
				+ "]";
	}

	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
