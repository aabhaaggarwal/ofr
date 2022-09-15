package com.cg.ofr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.service.IFlatService;

@RestController
public class FlatController {
	
	@Autowired
	private IFlatService iFlatService;

}
