package com.cg.ofr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.repository.IFlatBookingRepository;

@Service
public class IFlatBookingServiceImpl implements IFlatBookingService {

	@Autowired
	private IFlatBookingRepository iFlatBookingRepository;

	@Override
	public FlatBooking addFlatBooking(FlatBooking flatBooking) {
		return iFlatBookingRepository.save(flatBooking);
	}

	@Override
	public FlatBooking updateFlatBooking(FlatBooking flatBooking) throws FlatBookingNotFoundException {
		Optional<FlatBooking> optionalFlatBooking = iFlatBookingRepository.findById(flatBooking.getBookingNo());
		if (optionalFlatBooking.isEmpty()) {
			throw new FlatBookingNotFoundException("Flat Booking not existing with id :" + flatBooking.getBookingNo());
		}
		return iFlatBookingRepository.save(flatBooking);
	}

	@Override
	public void deleteFlatBooking(int id) throws FlatBookingNotFoundException {
		Optional<FlatBooking> optionalFlatBooking = iFlatBookingRepository.findById(id);
		if (optionalFlatBooking.isEmpty()) {
			throw new FlatBookingNotFoundException("Flat Booking not existing with id :" + id);
		}
		iFlatBookingRepository.deleteById(id);

	}

	@Override
	public FlatBooking viewFlatBooking(int id) throws FlatBookingNotFoundException {
		Optional<FlatBooking> optionalFlatBooking = iFlatBookingRepository.findById(id);
		if (optionalFlatBooking.isEmpty()) {
			throw new FlatBookingNotFoundException("Flat booking not existing with id :" + id);
		}
		return optionalFlatBooking.get();
	}

	@Override
	public List<FlatBooking> viewAllFlatBooking() {
		return iFlatBookingRepository.findAll();
	}
}
