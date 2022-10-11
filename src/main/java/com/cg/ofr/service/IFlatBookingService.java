package com.cg.ofr.service;

import java.util.List;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.FlatBookingNotFoundException;

public interface IFlatBookingService {

	public FlatBooking addFlatBooking(FlatBooking flatBooking);

	public FlatBooking updateFlatBooking(FlatBooking flatBooking) throws FlatBookingNotFoundException;

	public void deleteFlatBooking(int id) throws FlatBookingNotFoundException;

	public FlatBooking viewFlatBooking(int id) throws FlatBookingNotFoundException;

	public List<FlatBooking> viewAllFlatBooking();
	
	public List<FlatBooking> viewAllByTenant(int id);

	public List<FlatBooking> viewAllByApproval(String status);

	public List<FlatBooking> viewAllByLandlord(String status);


}

