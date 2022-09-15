package com.cg.ofr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.service.ILandlordService;

@RestController
public class LandlordController {
	
	@Autowired
	private ILandlordService iLandlordService;

}
