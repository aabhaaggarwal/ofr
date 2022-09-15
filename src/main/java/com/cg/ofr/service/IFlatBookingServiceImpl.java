package com.cg.ofr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.repository.IFlatBookingRepository;

@Service
public class IFlatBookingServiceImpl implements IFlatBookingService{
	
	@Autowired
	private IFlatBookingRepository iFlatBookingRepository;

	@Override
	public FlatBooking addFlatBooking(FlatBooking flatBooking) {
		//FlatBooking newFlatBooking = iFlatBookingRepository.save(flat);
		//return newFlatBooking;
		return null;
	}

	@Override
	public FlatBooking updateFlatBooking(FlatBooking flatBooking) throws FlatBookingNotFoundException {
		Optional<FlatBooking> optionalFlatBooking = iFlatBookingRepository.findById(flatBooking.getBookingNo());
		if(optionalFlatBooking.isEmpty()) {
			throw new FlatBookingNotFoundException("Flat Booking not existing with id :"+flatBooking.getBookingNo());
		}
		FlatBooking updatedFlatBooking = iFlatBookingRepository.save(flatBooking);
		return updatedFlatBooking;
	}

	@Override
	public void deleteFlatBooking(String id) throws FlatBookingNotFoundException {
		Optional<FlatBooking> optionalFlatBooking = iFlatBookingRepository.findById(id);
		if(optionalFlatBooking.isEmpty()) {
			throw new FlatBookingNotFoundException("Flat Booking not existing with id :"+id);
		}
		iFlatBookingRepository.deleteById(id);
		
	}

	@Override
	public FlatBooking viewFlatBooking(String id) throws FlatBookingNotFoundException {
		Optional<FlatBooking> optionalFlatBooking = iFlatBookingRepository.findById(id);
		if(optionalFlatBooking.isEmpty()) {
			throw new FlatBookingNotFoundException("Flat booking not existing with id :"+id);
		}
		FlatBooking flatBooking = optionalFlatBooking.get();
		return flatBooking;
	}

	@Override
	public List<FlatBooking> viewAllFlatBooking() {
		List<FlatBooking> flatBookings = iFlatBookingRepository.findAll();
		return flatBookings;
	}

}
