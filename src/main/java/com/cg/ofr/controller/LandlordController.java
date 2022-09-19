package com.cg.ofr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.service.ILandlordService;

@RestController
public class LandlordController {

	@Autowired
	private ILandlordService iLandlordService;

	@PostMapping("/landlord/save")
	public ResponseEntity<Landlord> addLandlord(@RequestBody Landlord landlord) {
		Landlord newLandlord = iLandlordService.addLandlord(landlord);
		return new ResponseEntity<>(newLandlord, HttpStatus.CREATED);
	}

	@PutMapping("/landlord/update")
	public ResponseEntity<Landlord> modifyLandlord(@RequestBody Landlord landlord) {
		Landlord updatedLandlord = iLandlordService.updateLandlord(landlord);
		return new ResponseEntity<>(updatedLandlord, HttpStatus.OK);
	}

	@DeleteMapping("/landlord/{lId}")
	public ResponseEntity<String> deleteLandlordById(@PathVariable("lId") int LandlordId) {
		iLandlordService.deleteLandlord(LandlordId);
		return new ResponseEntity<>("Lanlord deleted successfully!!", HttpStatus.OK);

	}

	@GetMapping("/landlord/{lId}")
	public ResponseEntity<Object> fetchLandlordById(@PathVariable("lId") int LandlordId) {
		Landlord landlord = iLandlordService.viewLandlord(LandlordId);
		return new ResponseEntity<>(landlord, HttpStatus.OK);
	}

	@GetMapping("/landlord/all")
	public List<Landlord> fetchAllLandlord() {
		return iLandlordService.viewAllLandlord();
	}

}
