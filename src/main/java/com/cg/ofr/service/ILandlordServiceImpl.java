package com.cg.ofr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.repository.ILandlordRepository;

@Service
public class ILandlordServiceImpl implements ILandlordService {

	@Autowired
	private ILandlordRepository iLandlordRepository;

	@Override
	public Landlord addLandlord(Landlord landlord) {
		return iLandlordRepository.save(landlord);
	}

	@Override
	public Landlord updateLandlord(Landlord landlord) throws LandlordNotFoundException {
		Optional<Landlord> optionalLandlord = iLandlordRepository.findById(landlord.getUserId());
		if (optionalLandlord.isEmpty()) {
			throw new LandlordNotFoundException("No landlord with this name:" + landlord.getUserId());
		}
		return iLandlordRepository.save(landlord);
	}

	@Override
	public void deleteLandlord(int landlordId) throws LandlordNotFoundException {
		Optional<Landlord> optionalLandlord = iLandlordRepository.findById(landlordId);
		if (optionalLandlord.isEmpty()) {
			throw new LandlordNotFoundException("Landlord not found with this id: " + landlordId);
		}
		iLandlordRepository.deleteById(landlordId);

	}

	@Override
	public Landlord viewLandlord(int id) throws LandlordNotFoundException {

		Optional<Landlord> optionalLandlord = iLandlordRepository.findById(id);
		if (optionalLandlord.isEmpty()) {
			throw new LandlordNotFoundException("Landlord not found with this id: " + id);
		}
		return optionalLandlord.get();
	}

	@Override
	public List<Landlord> viewAllLandlord() {
		return iLandlordRepository.findAll();
	}
}
