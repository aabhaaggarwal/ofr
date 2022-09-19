package com.cg.ofr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.repository.IFlatRepository;

@Service
public class IFlatServiceImpl implements IFlatService {
	
	@Autowired
	private IFlatRepository iFlatRepository;

	@Override
	public Flat addFlat(Flat flat) {
		Flat newFlat = iFlatRepository.save(flat);
		return newFlat;
	}

	@Override
	public Flat updateFlat(Flat flat) throws FlatNotFoundException {
		Optional<Flat> optionalFlat = iFlatRepository.findById(flat.getFlatId());
		if(optionalFlat.isEmpty()) {
			throw new FlatNotFoundException("No Flat With This Id"+flat.getFlatId());
		}
		Flat updatedFlat = iFlatRepository.save(flat);	
		return updatedFlat;
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
		List<Flat> flat = iFlatRepository.findAll();
		return flat;
	}

	@Override
	public List<Flat> viewAllFlatByCost(float cost, String availability) {
		// TODO Auto-generated method stub
		return null;
	}

}