package com.cg.ofr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.service.ILandlordService;

@RestController
public class LandlordController {

	@Autowired
	private ILandlordService iLandlordService;

	@PostMapping("/landlord/save")
	public ResponseEntity<Landlord> addLandlord(@RequestBody Landlord landlord) {
		Landlord newLandlord = iLandlordService.addLandlord(landlord);
		ResponseEntity<Landlord> responseEntity = new ResponseEntity<>(newLandlord, HttpStatus.CREATED);
		return responseEntity;
	}

	@PutMapping("/landlord/update")
	public ResponseEntity<Landlord> modifyLandlord(@RequestBody Landlord landlord) {
		Landlord updatedLandlord = iLandlordService.updateLandlord(landlord);
		ResponseEntity<Landlord> responseEntity = new ResponseEntity<>(updatedLandlord, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/landlord/{lId}")
	public ResponseEntity<String> deleteLandlordById(@PathVariable("lId") String LandlordId) {
		iLandlordService.deleteLandlord(LandlordId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Lanlord deleted successfully!!", HttpStatus.OK);
		return responseEntity;

	}

	@GetMapping("/landlord/{lId}")
	public ResponseEntity<Object> fetchLandlordById(@PathVariable("lId") String LandlordId) {
		Landlord landlord = iLandlordService.viewLandlord(LandlordId);
		ResponseEntity<Object> responseEntity = new ResponseEntity<>(landlord, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/landlord/all")
	public List<Landlord> fetchAllLandlord() {
		List<Landlord> landlords = iLandlordService.viewAllLandlord();
		return landlords;
	}

}
