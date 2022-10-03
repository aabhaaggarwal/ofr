package com.cg.ofr.service;

import com.cg.ofr.entities.Admin;

import com.cg.ofr.exception.AdminNotFoundException;

public interface IAdminService {

	public Admin validateAdmin(String username, String password) throws AdminNotFoundException;

	public Admin updateAdmin(Admin admin) throws AdminNotFoundException;

	public Admin addAdmin(Admin admin);
	
	public Admin forgetPassword(String email);

}
