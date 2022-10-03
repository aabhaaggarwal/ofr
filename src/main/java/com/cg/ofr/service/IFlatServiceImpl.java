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
		return iFlatRepository.save(flat);
	}

	@Override
	public List<Flat> viewAllFlat() {
		return iFlatRepository.findAll();
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
		return optionalFlat.get();
	}

	@Override
	public Flat updateFlat(Flat flat) throws FlatNotFoundException {
		Optional<Flat> optionalFlat = iFlatRepository.findById(flat.getFlatId());
		if (optionalFlat.isEmpty()) {
			throw new FlatNotFoundException("Flat not existing with id:" + flat.getFlatId());
		}
		return iFlatRepository.save(flat);
	}

	@Override
	public List<Flat> viewAllFlatByCost(float mincost, float maxcost) {
		List<Flat> flats = iFlatRepository.findByCost(mincost, maxcost);
		if (flats.isEmpty()) {
			throw new FlatNotFoundException("Flat not existing in this range");
		}
		return flats;
	}

	@Override
	public List<Flat> viewAllFlatByCity(String city) {
		List<Flat> flats = iFlatRepository.findByCity(city);
		if (flats.isEmpty()) {
			throw new FlatNotFoundException("Flat not existing in this city");
		}
		return flats;
	}

	@Override
	public List<Flat> viewAllFlatByAvailability() {
		List<Flat> flats = iFlatRepository.findByAvailability();
		if (flats.isEmpty()) {
			throw new FlatNotFoundException("Flat is not available");
		}
		return flats;
	}

	@Override
	public List<Flat> viewAllFlatByType(String type) {
		List<Flat> flats = iFlatRepository.findByType(type);
		if (flats.isEmpty()) {
			throw new FlatNotFoundException("Flat is not available");
		}
		return flats;
	}

}