package com.cg.ofr.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "flat_tbl")
public class Flat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flat_id")
	private int flatId;

	@NotNull(message = "This field cannot be null")
	@Positive(message = "Cost must be positive value")
	@Column(name = "cost")
	private float cost;

	@NotNull(message = "This field cannot be null")
	@Column(name = "flat_type", length = 20)
	private String flatType;

	@NotNull(message = "This field cannot be null")
	@Column(name = "availability", length = 20)
	private String availability;
	
	@NotNull(message = "This field cannot be null")
	@Column(name = "status", length = 20)
	private String status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "flat_address")
	private FlatAddress flatAddress;

	@ManyToOne
	@JoinColumn(name = "landlord")
	private Landlord landlord;

	@JsonIgnore
	@OneToOne(mappedBy = "flat")
	private FlatBooking flatBooking;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getFlatId() {
		return flatId;
	}

	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getFlatType() {
		return flatType;
	}

	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public FlatAddress getFlatAddress() {
		return flatAddress;
	}

	public void setFlatAddress(FlatAddress flatAddress) {
		this.flatAddress = flatAddress;
	}

	public Landlord getLandlord() {
		return landlord;
	}

	public void setLandlord(Landlord landlord) {
		this.landlord = landlord;
	}

	public FlatBooking getFlatBooking() {
		return flatBooking;
	}

	public void setFlatBooking(FlatBooking flatBooking) {
		this.flatBooking = flatBooking;

	}

}
	