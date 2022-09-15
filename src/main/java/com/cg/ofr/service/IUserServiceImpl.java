package com.cg.ofr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.entities.User;
import com.cg.ofr.exception.UserNotFoundException;
import com.cg.ofr.repository.IUserRepository;

@Service
public class IUserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepository iUserRepository;

	@Override
	public Tenant validateTenant(String username, String password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Landlord validateLandlord(String username, String password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tenant updateTenantPassword(User user, String newpass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Landlord updateLandlordPassword(User user, String newpass) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
