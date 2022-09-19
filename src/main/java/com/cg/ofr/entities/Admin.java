package com.cg.ofr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "admin_tbl")
public class Admin {

	@Id
	@Column(name = "username", length = 20, nullable = false, unique = true)
	private String username;

	@Column(name = "password", length = 20, nullable = false)
	private String password;
	
	@NotNull(message = "This field cannot be null")
	@Column(name = "admin_name", length = 50, nullable = false)
	private String adminName;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

}
