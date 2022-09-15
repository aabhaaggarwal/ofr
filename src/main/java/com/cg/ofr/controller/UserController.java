package com.cg.ofr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService iUserService;
	
}
