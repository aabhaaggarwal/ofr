package com.cg.ofr.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "landlord_tbl")
public class Landlord extends User {
    @NotNull(message = "name shoul not be null")
	@Column(name = "landlord_name", length = 100, nullable = false)
	private String landlordName;
	
	@Email(regexp = "^(.+)@(.+)$")
	@Column(name = "email", length = 100, nullable = false, unique = true)
	private String email;

	@Positive(message = "age must be positive")
	@Column(name = "age", nullable = false)
	private int age;

	@Size(min =10, max=10)
	@Column(name = "mobile", length = 10, nullable = false)
	private String mobile;

	@OneToMany(mappedBy = "landlord")
	private List<Flat> flats;

	public String getLandlordName() {
		return landlordName;
	}

	public void setLandlordName(String landlordName) {
		this.landlordName = landlordName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Flat> getFlats() {
		return flats;
	}

	public void setFlats(List<Flat> flats) {
		this.flats = flats;
	}
}
