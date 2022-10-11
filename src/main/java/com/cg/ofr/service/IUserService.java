package com.cg.ofr.service;

import com.cg.ofr.entities.User;

public interface IUserService {

	public User validateUser(String username, String password,String role);
	
	public User validateEmail(String email,String role,String password);


}
