package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.LandlordNotFoundException;

public interface ILandlordService {

	public Landlord addLandlord(Landlord landlord);

	public Landlord updateLandlord(Landlord landlord) throws LandlordNotFoundException;

	public void deleteLandlord(int landlordId) throws LandlordNotFoundException;

	public Landlord viewLandlord(int id) throws LandlordNotFoundException;

	public List<Landlord> viewAllLandlord();

}
