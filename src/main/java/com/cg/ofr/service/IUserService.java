package com.cg.ofr.service;

import com.cg.ofr.entities.Admin;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.entities.Tenant;

import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.exception.TenantNotFoundException;

public interface IUserService {

	public Tenant validateTenant(String username, String password) throws TenantNotFoundException;

	public Landlord validateLandlord(String username, String password) throws LandlordNotFoundException;

	public Tenant forgetPasswordTenant(String email);

	public Landlord forgetPasswordLandlord(String email);

}
