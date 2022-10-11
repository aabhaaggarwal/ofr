package com.cg.ofr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.entities.User;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.ILandlordRepository;
import com.cg.ofr.repository.IUserRepository;

@Service
public class ILandlordServiceImpl implements ILandlordService {

	@Autowired
	private ILandlordRepository iLandlordRepository;
	@Autowired
	private IUserRepository iUserRepository;

	@Override
	public Landlord addLandlord(Landlord landlord) {
		Optional<User> user =iUserRepository.findByUsername(landlord.getUsername());
		Optional<User> user1=iUserRepository.findByEmail(landlord.getEmail());
		if(!user.isEmpty()) {
			throw new TenantNotFoundException("This username is not available");
		}
		if(!user1.isEmpty()) {
			throw new TenantNotFoundException("This email is already registered");
		}
		landlord.setRole("landlord");
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
