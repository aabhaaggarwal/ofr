package com.cg.ofr.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@Positive(message = "Cost must be positive value")
	@Column(name = "cost")
	private float cost;

	@Column(name = "flat_type", length = 20)
	private String flatType;

	@Column(name = "availability", length = 20)
	private String availability;
	
	@Column(name = "status", length = 20)
	private String status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "flat_address")
	private FlatAddress flatAddress;

	@ManyToOne
	@JoinColumn(name = "landlord")
	private Landlord landlord;

	@JsonIgnore
	@OneToMany(mappedBy = "flat")
	private List<FlatBooking> flatBooking;
	
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

	public List<FlatBooking> getFlatBooking() {
		return flatBooking;
	}

	public void setFlatBooking(List<FlatBooking> flatBooking) {
		this.flatBooking = flatBooking;
	}

	

}
	