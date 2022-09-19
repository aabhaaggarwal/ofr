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
	public List<Flat> viewAllFlat() {
		List<Flat> flat = iFlatRepository.findAll();
		return flat;
	}

	@Override
	public void deleteFlat(int flatId) throws FlatNotFoundException {
		Optional<Flat> optionalFlat = iFlatRepository.findById(flatId);
		if (optionalFlat.isEmpty()) {
			throw new FlatNotFoundException("Flat not existing with id:" + flatId);
		}
		iFlatRepository.deleteById(flatId);
	}

	@Override
	public Flat viewFlat(int id) throws FlatNotFoundException {
		Optional<Flat> optionalFlat = iFlatRepository.findById(id);
		if (optionalFlat.isEmpty()) {
			throw new FlatNotFoundException("Flat not existing with id: " + id);
		}
		Flat flat = optionalFlat.get();
		return flat;
	}

	@Override
	public List<Flat> viewAllFlatByCost(float cost, String availability) {
		List<Flat> flats = iFlatRepository.findByCostAndAvailability(cost, availability);
		if (flats.isEmpty()) {
			throw new FlatNotFoundException("Flat not existing with cost:" + cost);
		}
		return flats;
	}

	@Override
	public Flat updateFlat(Flat flat) throws FlatNotFoundException {
		Optional<Flat> optionalFlat = iFlatRepository.findById(flat.getFlatId());
		if (optionalFlat.isEmpty()) {
			throw new FlatNotFoundException("Flat not existing with id:" + flat.getFlatId());
		}
		Flat updatedFlat = iFlatRepository.save(flat);
		return updatedFlat;
	}

}