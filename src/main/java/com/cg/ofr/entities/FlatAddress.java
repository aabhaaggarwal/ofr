package com.cg.ofr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "flataddress_tbl")
public class FlatAddress {

	@Id
	@Column(name = "address_id")
	private String addressId;

	@Column(name = "houseno")
	private int houseNo;

	@Column(name = "building", length = 50)
	private String building;

	@Column(name = "street", length = 50)
	private String street;

	@Column(name = "city", length = 30)
	private String city;

	@Column(name = "state", length = 30)
	private String state;

	@Column(name = "pincode")
	private int pincode;

	@Column(name = "country", length = 30)
	private String country;

	@JsonIgnore
	@OneToOne(mappedBy = "flatAddress")
	private Flat flat;

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Flat getFlat() {
		return flat;
	}

	public void setFlat(Flat flat) {
		this.flat = flat;
	}
}
