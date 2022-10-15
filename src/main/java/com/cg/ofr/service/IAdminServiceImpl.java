package com.cg.ofr.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Admin;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.entities.User;
import com.cg.ofr.exception.AdminNotFoundException;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.IAdminRepository;
import com.cg.ofr.repository.IUserRepository;

@Service
public class IAdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepository iAdminRepository;
	@Autowired
	private IUserRepository iUserRepository;


	@Override
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException {
		Optional<Admin> optionalAdmin = iAdminRepository.findById(admin.getUserId());
		if (optionalAdmin.isEmpty()) {
			throw new AdminNotFoundException("Admin not existing with this username");
		}
		return iAdminRepository.save(admin);
	}

	@Override
	public Admin addAdmin(Admin admin) {
		Optional<User> user =iUserRepository.findByUsername(admin.getUsername());
		Optional<User> user1=iUserRepository.findByEmail(admin.getEmail());
		if(!user.isEmpty()) {
			throw new AdminNotFoundException("This username is not available");
		}
		if(!user1.isEmpty()) {
			throw new AdminNotFoundException("This email is already registered");
		}
		admin.setRole("admin");
		return iAdminRepository.save(admin);
	}
	
	@Override
	public Admin viewAdmin(int id) throws AdminNotFoundException {
		Optional<Admin> optionalAdmin = iAdminRepository.findById(id);
		if (optionalAdmin.isEmpty()) {
			throw new AdminNotFoundException("Admin not existing with id: " + id);
		}
		return optionalAdmin.get();
	}

}
