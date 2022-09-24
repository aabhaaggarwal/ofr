package com.cg.ofr.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.IFlatBookingRepository;
import com.cg.ofr.repository.IFlatRepository;
import com.cg.ofr.repository.ITenantRepository;

@Service
public class IFlatBookingServiceImpl implements IFlatBookingService {

	@Autowired
	private IFlatBookingRepository iFlatBookingRepository;
	
	@Autowired
	private IFlatRepository iFlatRepository;
	
	@Autowired
	private ITenantRepository iTenantRepository;

	@Override
	public FlatBooking addFlatBooking(FlatBooking flatBooking) {
		Optional<Flat> flat = iFlatRepository.findById(flatBooking.getFlat().getFlatId());
		Optional<Tenant> tenant =iTenantRepository.findById(flatBooking.getTenant().getUserId());
		if(tenant.get().getFlatBooking()!=null) {
			throw new TenantNotFoundException("Tenant with this id has already booked a flat");
		}
		if(flat.get().getAvailability().equals("not available")) {
			throw new FlatNotFoundException("Flat is not available with id :"+flat.get().getFlatId());
		}
		if(flatBooking.getBookingFrom().compareTo(flatBooking.getBookingTo())>0 || flatBooking.getBookingFrom().compareTo(flatBooking.getBookingTo())==0) {
			throw new FlatBookingNotFoundException("Booking end date should exceed booking start date");
		}
		flat.get().setAvailability("not available");
		return iFlatBookingRepository.save(flatBooking);
	}

	@Override
	public FlatBooking updateFlatBooking(FlatBooking flatBooking) throws FlatBookingNotFoundException {
		Optional<FlatBooking> optionalFlatBooking = iFlatBookingRepository.findById(flatBooking.getBookingNo());
		Optional<Flat> flat = iFlatRepository.findById(flatBooking.getFlat().getFlatId());
		Optional<Tenant> tenant =iTenantRepository.findById(flatBooking.getTenant().getUserId());
		if(tenant.get().getFlatBooking()!=null) {
			throw new TenantNotFoundException("Tenant with this id has already booked a flat");
		}
		if (optionalFlatBooking.isEmpty()) {
			throw new FlatBookingNotFoundException("Flat Booking not existing with id :" + flatBooking.getBookingNo());
		}
		if(flat.get().getAvailability().equals("not available")) {
			throw new FlatNotFoundException("Flat is not available with id :"+flat.get().getFlatId());
		}
		if(flatBooking.getBookingFrom().compareTo(flatBooking.getBookingTo())>0 || flatBooking.getBookingFrom().compareTo(flatBooking.getBookingTo())==0) {
			throw new FlatBookingNotFoundException("Booking end date should exceed booking start date");
		}
		flat.get().setAvailability("not available");
		return iFlatBookingRepository.save(flatBooking);
	}

	@Override
	public void deleteFlatBooking(int id) throws FlatBookingNotFoundException {
		Optional<FlatBooking> optionalFlatBooking = iFlatBookingRepository.findById(id);
		if (optionalFlatBooking.isEmpty()) {
			throw new FlatBookingNotFoundException("Flat Booking not existing with id :" + id);
		}
		optionalFlatBooking.get().getFlat().setAvailability("available");
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
