package com.cg.ofr.service;

import java.util.List;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.FlatBookingNotFoundException;

public interface IFlatBookingService {
	
	public FlatBooking addFlatBooking(FlatBooking flatBooking) ;
	public FlatBooking updateFlatBooking(FlatBooking flatBooking) throws FlatBookingNotFoundException;
	public void deleteFlatBooking(String id) throws FlatBookingNotFoundException;
	public FlatBooking viewFlatBooking(String id) throws FlatBookingNotFoundException;
	public List<FlatBooking> viewAllFlatBooking();

	//view flat booking by landlord id and flat id
	//view all flats by landlord id and flat id
	
}

