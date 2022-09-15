package com.cg.ofr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tenant_tbl")
public class Tenant extends User{
	
	@Column(name="tenant_name",length=50,nullable=false)
	private String tenantName;
	
	@Column(name="age", nullable=false)
	private int age;
	
	@Column(name="email", length=100, nullable=false, unique=true)
	private String email;
	
	@Column(name="gender",length=20)
	private String gender;
	
	@Column(name="mobile",length=10,nullable=false)
	private String mobile;
	
	@Column(name="permanent_addr",nullable=true)
	private String permanentAddr;
	
	@JsonIgnore
	@OneToOne(mappedBy="tenant")
	private FlatBooking flatBooking;

	public FlatBooking getFlatBooking() {
		return flatBooking;
	}

	public void setFlatBooking(FlatBooking flatBooking) {
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
