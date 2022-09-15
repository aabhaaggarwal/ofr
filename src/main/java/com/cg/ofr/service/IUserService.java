package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.entities.User;
import com.cg.ofr.exception.UserNotFoundException;

public interface IUserService {
	
	public Tenant validateTenant(String username,String password) throws UserNotFoundException;
	public Landlord validateLandlord(String username,String password) throws UserNotFoundException;
	public Tenant updateTenantPassword(User user,String newpass);
	public Landlord updateLandlordPassword(User user,String newpass);
	//public User removeUser(User user);

}
