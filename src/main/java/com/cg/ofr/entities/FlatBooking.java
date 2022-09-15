package com.cg.ofr.entities;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="flatbooking_tbl")
public class FlatBooking {
	
	@Id
	@Column(name="booking_no", length=20)
	private String bookingNo;
	
	@Column(name="booking_from")
	private LocalDate bookingFrom;
	
	@Column(name="booking_to")
	private LocalDate bookingTo;
	
	@Column(name="members")
	private int members;
	
	@Column(name="purpose", length=30)
	private String purpose;
	
	@OneToOne
	@JoinColumn(name="flat")
	private Flat flat;
	
	@OneToOne
	@JoinColumn(name="tenant")
	private Tenant tenant;

	public String getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}

	public LocalDate getBookingFrom() {
		return bookingFrom;
	}

	public void setBookingFrom(LocalDate bookingFrom) {
		this.bookingFrom = bookingFrom;
	}

	public LocalDate getBookingTo() {
		return bookingTo;
	}

	public void setBookingTo(LocalDate bookingTo) {
		this.bookingTo = bookingTo;
	}

	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Flat getFlat() {
		return flat;
	}

	public void setFlat(Flat flat) {
		this.flat = flat;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
}
