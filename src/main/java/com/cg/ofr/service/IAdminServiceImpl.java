package com.cg.ofr.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Admin;

import com.cg.ofr.exception.AdminNotFoundException;

import com.cg.ofr.repository.IAdminRepository;

@Service
public class IAdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepository iAdminRepository;

	@Override
	public Admin validateAdmin(String username, String password) throws AdminNotFoundException {
		Admin optionalAdmin = iAdminRepository.findByUsernameAndPassword(username, password);
		if (optionalAdmin == null) {
			throw new AdminNotFoundException("Admin not existing with username and password");
		}
		return optionalAdmin;
	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException {
		Optional<Admin> optionalAdmin = iAdminRepository.findById(admin.getUsername());
		if (optionalAdmin.isEmpty()) {
			throw new AdminNotFoundException("Admin not existing with this username");
		}
		return iAdminRepository.save(admin);
	}

	@Override
	public Admin addAdmin(Admin admin) {
		return iAdminRepository.save(admin);
	}

	@Override
	public Admin forgetPassword(String email) {
		Admin admin = iAdminRepository.findByEmail(email);
		if(admin==null) {
			throw new AdminNotFoundException("Admin not existing");
		}
		return admin;
	}

}
