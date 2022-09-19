package com.cg.ofr.service;



import com.cg.ofr.entities.Landlord;
import com.cg.ofr.entities.Tenant;

import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.exception.TenantNotFoundException;


public interface IUserService {
	
	public Tenant validateTenant(String username,String password) throws TenantNotFoundException;
	public Landlord validateLandlord(String username,String password) throws LandlordNotFoundException;
	public Tenant updateTenantPassword(Tenant tenant) throws TenantNotFoundException;
	public Landlord updateLandlordPassword(Landlord landlord) throws LandlordNotFoundException;
	public Tenant validateNewTenant(Tenant tenant) throws TenantNotFoundException;
	public Landlord validateNewLandlord(Landlord landlord) throws LandlordNotFoundException;
	
}
