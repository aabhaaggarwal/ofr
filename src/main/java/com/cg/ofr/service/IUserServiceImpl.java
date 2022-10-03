package com.cg.ofr.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Admin;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.AdminNotFoundException;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.ILandlordRepository;
import com.cg.ofr.repository.ITenantRepository;

@Service
public class IUserServiceImpl implements IUserService {

	@Autowired
	private ITenantRepository iTenantRepository;

	@Autowired
	private ILandlordRepository iLandlordRepository;

	@Override
	public Landlord validateLandlord(String username, String password) throws LandlordNotFoundException {
		Landlord optionallandlord = iLandlordRepository.findByUsernameAndPassword(username, password);
		if (optionallandlord == null) {
			throw new LandlordNotFoundException("Landlord not existing with username and password");
		}
		return optionallandlord;

	}


	@Override
	public Tenant validateTenant(String username, String password) throws TenantNotFoundException {
		Tenant tenant = iTenantRepository.findByUsernameAndPassword(username, password);
		if (tenant == null) {
			throw new TenantNotFoundException("Tenant not existing with username and password");
		}
		return tenant;

	}


	@Override
	public Tenant forgetPasswordTenant(String email) {
		Tenant tenant = iTenantRepository.findByEmail(email);
		if(tenant==null) {
			throw new TenantNotFoundException("Admin not existing");
		}
		return tenant;
	}


	@Override
	public Landlord forgetPasswordLandlord(String email) {
		Landlord landlord = iLandlordRepository.findByEmail(email);
		if(landlord==null) {
			throw new TenantNotFoundException("Admin not existing");
		}
		return landlord;
	}


}