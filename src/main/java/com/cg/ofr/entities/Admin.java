package com.cg.ofr.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="admin_tbl")
@PrimaryKeyJoinColumn(name = "user_id")
public class Admin extends User{

	@NotNull(message = "This field cannot be null")
	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 50)
	private String lastName;
	
	@Size(min=10,max=10)
	@NotNull(message = "This field cannot be null")
	@Column(name = "mobile", length = 10, nullable = false)
	private String mobile;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
