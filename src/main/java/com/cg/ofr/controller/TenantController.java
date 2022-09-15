package com.cg.ofr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.service.ITenantService;

@RestController
public class TenantController {

	@Autowired
	private ITenantService iTenantService;
}
