package com.cg.ofr.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tenant_tbl")
public class Tenant extends User {

	@NotNull(message = "Name cannot be null")
	@Column(name = "tenant_name", length = 50, nullable = false)
	private String tenantName;

	@Positive(message = "age must be positive number")
	@Column(name = "age", nullable = false)
	private int age;

	@Email(regexp = "^(.+)@(.+)$")
	@Column(name = "email", length = 100, nullable = false, unique = true)
	private String email;

	@Column(name = "gender", length = 20)
	private String gender;

	@Size(min=10,max=10)
	@Column(name = "mobile", length = 10, nullable = false)
	private String mobile;

	@Column(name = "permanent_addr", nullable = true)
	private String permanentAddr;

	@JsonIgnore
	@OneToMany(mappedBy = "tenant")
	private List<FlatBooking> flatBooking;

	public List<FlatBooking> getFlatBooking() {
		return flatBooking;
	}

	public void setFlatBooking(List<FlatBooking> flatBooking) {
		this.flatBooking = flatBooking;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPermanentAddr() {
		return permanentAddr;
	}

	public void setPermanentAddr(String permanentAddr) {
		this.permanentAddr = permanentAddr;
	}
}
