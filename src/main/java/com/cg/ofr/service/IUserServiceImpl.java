package com.cg.ofr.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.entities.Tenant;
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
		Landlord optionallandlord=iLandlordRepository.findByUsernameAndPassword(username, password);
		if(optionallandlord==null) {
			throw new LandlordNotFoundException("Landlord not existing with username and password");
		}
		return optionallandlord;
		
	}

	@Override
	public Tenant updateTenantPassword(Tenant tenant) {
		Optional<Tenant> optionalTenant=iTenantRepository.findById(tenant.getUserId());
		if(optionalTenant.isEmpty()) {
			throw new TenantNotFoundException("Tenant not existing with id:"+tenant.getUserId());
		}
		Tenant updateTenant=iTenantRepository.save(tenant);
		return updateTenant;
		
	}

	@Override
	public Landlord updateLandlordPassword(Landlord landlord) {
		Optional<Landlord> optionalLandlord=iLandlordRepository.findById(landlord.getUserId());
		if(optionalLandlord.isEmpty()) {
			throw new LandlordNotFoundException("Landlord not existing with username:"+landlord.getUsername());
		}
		Landlord updateLandlord=iLandlordRepository.save(landlord);
		return updateLandlord;
	}

	@Override
	public Tenant validateTenant(String username, String password) throws TenantNotFoundException {
		Tenant tenant=iTenantRepository.findByUsernameAndPassword(username, password);
		if(tenant==null) {
			throw new TenantNotFoundException("Tenant not existing with username and password");
		}
		return tenant;
		
		
		
	}

	@Override
	public Tenant validateNewTenant(Tenant tenant) throws TenantNotFoundException {
		Tenant optionaltenant=iTenantRepository.findByUsername(tenant.getUsername());
		if(optionaltenant!=null) {
			throw new TenantNotFoundException("Tenant with this name already exist");
		}
		Tenant newTenant=iTenantRepository.save(tenant);
		return newTenant;
	}

	@Override
	public Landlord validateNewLandlord(Landlord landlord) throws LandlordNotFoundException {
		Landlord optionallandlord=iLandlordRepository.findByUsername(landlord.getUsername());
		if(optionallandlord!=null) {
			throw new LandlordNotFoundException("Landlord with this name already exist");
		}
		Landlord newLandlord=iLandlordRepository.save(landlord);
		return newLandlord;
		}

	
	

	

	
	

	

}