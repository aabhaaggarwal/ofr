package com.cg.ofr.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.ofr.entities.User;
import com.cg.ofr.exception.AuthenticationFailureException;
import com.cg.ofr.exception.UserNotFoundException;
import com.cg.ofr.repository.IUserRepository;

@Service
public class IUserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository iUserRepository;
	
	@Override
    public  User validateUser(String username, String password,String role) {
        Optional<User> optionalUser = iUserRepository.findByUsername(username);
        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException("Username is not existing.");
        }
        User user = optionalUser.get();
        if(!password.equals(user.getPassword()) ) {
            throw new AuthenticationFailureException("Invalid Password.");
        }   
        if(!role.equals(user.getRole()) ) {
            throw new AuthenticationFailureException("Invalid Role");
        }
        return user;
    }



	@Override
	public User validateEmail(String email, String role, String password) {
		Optional<User> optionalUser = iUserRepository.findByEmailAndRole(email,role);
		if(optionalUser.isEmpty()) {
			throw new AuthenticationFailureException("Invalid email or role");
		}
		User user = optionalUser.get();
		user.setPassword(password);
		return iUserRepository.save(user);
	}


}