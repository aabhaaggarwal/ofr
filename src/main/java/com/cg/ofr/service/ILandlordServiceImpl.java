package com.cg.ofr.service;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Landlord updateLandlord(Landlord landlord) throws LandlordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Landlord deleteLandlord(Landlord landlord) throws LandlordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Landlord viewLandlord(String id) throws LandlordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Landlord> viewAllLandlord() {
		// TODO Auto-generated method stub
		return null;
	}

}
