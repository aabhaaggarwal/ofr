package com.cg.ofr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.repository.ILandlordRepository;

@Service
public class ILandlordServiceImpl implements ILandlordService{
	
	@Autowired
	private ILandlordRepository iLandlordRepository;

	@Override
	public Landlord addLandlord(Landlord landlord) {
		Landlord newLandlord = iLandlordRepository.save(landlord);
		return newLandlord;
	}

	@Override
	public Landlord updateLandlord(Landlord landlord) throws LandlordNotFoundException {
		Optional<Landlord> optionalLandlord = iLandlordRepository.findById(landlord.getUserId());
		if(optionalLandlord.isEmpty()) {
			throw new LandlordNotFoundException("No landlord with this name:"+landlord.getUserId());
		}
		Landlord updatedLandlord = iLandlordRepository.save(landlord);
		return updatedLandlord;
	}
	
	

	@Override
	public void deleteLandlord(String landlordId) throws LandlordNotFoundException {
		Optional<Landlord> optionalLandlord = iLandlordRepository.findById(landlordId);
        if(optionalLandlord.isEmpty()) {
			throw new LandlordNotFoundException("Landlord not found with this id: "+landlordId);
		}
		iLandlordRepository.deleteById(landlordId);
		
	}

	@Override
	public Landlord viewLandlord(String id) throws LandlordNotFoundException {
		
		Optional<Landlord> optionalLandlord = iLandlordRepository.findById(id);
		if(optionalLandlord.isEmpty()) {
			throw new LandlordNotFoundException("Landlord not found with this id: "+id);
		}
		Landlord landlord = optionalLandlord.get();
		return landlord;
	}

	@Override
	public List<Landlord> viewAllLandlord() {
		List<Landlord> landlord = iLandlordRepository.findAll();
		return landlord;
	}
}
