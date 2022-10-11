package com.cg.ofr.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tenant_tbl")
@PrimaryKeyJoinColumn(name = "user_id")
public class Tenant extends User {
	
	@NotNull(message = "Name cannot be null")
	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;
	
	@NotNull(message = "Name cannot be null")
	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;

	@Positive(message = "age must be positive number")
	@Column(name = "age", nullable = false)
	private int age;

	@Column(name = "gender", length = 20)
	private String gender;
	
	@Size(min=10,max=10)
	@Column(name = "mobile", length = 10, nullable = false)
	private String mobile;

	@JsonIgnore
	@OneToMany(mappedBy = "tenant")
	private List<FlatBooking> flatBooking;
	
	

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public List<FlatBooking> getFlatBooking() {
		return flatBooking;
	}

	public void setFlatBooking(List<FlatBooking> flatBooking) {
		this.flatBooking = flatBooking;
	}
}
