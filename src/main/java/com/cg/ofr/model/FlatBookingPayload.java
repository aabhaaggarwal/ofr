package com.cg.ofr.model;

import java.time.LocalDate;

public class FlatBookingPayload {

	private String bookingNo;
	private LocalDate bookingFrom;
	private LocalDate bookingTo;
	private int members;
	private String flatId;
	private String tenantId;

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

	public String getFlatId() {
		return flatId;
	}

	public void setFlatId(String flatId) {
		this.flatId = flatId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
}
