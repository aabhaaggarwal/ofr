package com.cg.ofr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "admin_tbl")
public class Admin extends User{

	@Column(name = "email", nullable = false,unique=true)
	private String email;
	
	@NotNull(message = "This field cannot be null")
	@Column(name = "admin_name", length = 50, nullable = false)
	private String adminName;

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
