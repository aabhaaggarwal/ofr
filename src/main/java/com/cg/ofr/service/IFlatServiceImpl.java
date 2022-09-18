package com.cg.ofr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.repository.IFlatRepository;

@Service
public class IFlatServiceImpl implements IFlatService{
	
	@Autowired
	private IFlatRepository iFlatRepository;

	@Override
	public Flat addFlat(Flat flat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flat updateFlat(Flat flat) throws FlatNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flat deleteFlat(Flat flat) throws FlatNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flat viewFlat(String id) throws FlatNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flat> viewAllFlat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flat> viewAllFlatByCost(float cost, String availability) {
		// TODO Auto-generated method stub
		return null;
	}

}
