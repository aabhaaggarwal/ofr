package com.cg.ofr.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.model.FlatPayload;
import com.cg.ofr.service.IFlatService;
import com.cg.ofr.service.ILandlordService;

@RestController
@RequestMapping("/flat")
public class FlatController {

	@Autowired
	private IFlatService iFlatService;

	@Autowired
	private ILandlordService iLandlordService;

	@PostMapping("/save")
	public ResponseEntity<Flat> addFlat(@RequestBody FlatPayload flatPayload) {

		Landlord landlord = iLandlordService.viewLandlord(flatPayload.getLandlordId());
		Flat flat = new Flat();
		flat.setFlatId(flatPayload.getFlatId());
		flat.setCost(flatPayload.getCost());
		flat.setFlatType(flatPayload.getFlatType());
		flat.setAvailability(flatPayload.getAvailability());
		flat.setFlatAddress(flatPayload.getFlatAddress());
		flat.setLandlord(landlord);
		Flat newFlat = iFlatService.addFlat(flat);
		return new ResponseEntity<>(newFlat, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public List<Flat> fetchAllFlat() {
		return iFlatService.viewAllFlat();
		
	}

	@GetMapping("/{fId}")
	public ResponseEntity<Object> fetchFlatById(@PathVariable("fId") int flatId) {
		Flat flat = iFlatService.viewFlat(flatId);
		return new ResponseEntity<>(flat, HttpStatus.OK);
	
	}

	@DeleteMapping("/{fId}")
	public ResponseEntity<String> deleteFlatById(@PathVariable("fId") int flatId) {
		iFlatService.deleteFlat(flatId);
	    return new ResponseEntity<>("Flat deleted successfully", HttpStatus.OK);
	
	}

	@GetMapping("/{minCost}/{maxCost}")
	public ResponseEntity<Object> fetchFlatByCost(@PathVariable("minCost") float minCost,@PathVariable("maxCost") float maxCost) {
		List<Flat> flats = iFlatService.viewAllFlatByCost(minCost,maxCost);
		return new ResponseEntity<>(flats, HttpStatus.OK);
		
	}

	@GetMapping("/{city}")
	public ResponseEntity<Object> fetchFlatByCity(@PathVariable("city") String city) {
		List<Flat> flats = iFlatService.viewAllFlatByCity(city);
		return new ResponseEntity<>(flats, HttpStatus.OK);
		
	}


	@GetMapping("/available")
	public ResponseEntity<Object> fetchFlatByAvailability() {
		List<Flat> flats = iFlatService.viewAllFlatByAvailability();
		return new ResponseEntity<>(flats, HttpStatus.OK);
		
	}


	@GetMapping("/{type}")
	public ResponseEntity<Object> fetchFlatBytype(@PathVariable("type") String type) {
		List<Flat> flats = iFlatService.viewAllFlatByType(type);
		return new ResponseEntity<>(flats, HttpStatus.OK);
		
	}

	@PutMapping("/update")
	public ResponseEntity<Flat> updateFlat(@RequestBody FlatPayload flatPayload) {

		Landlord landlord = iLandlordService.viewLandlord(flatPayload.getLandlordId());
		Flat flat = new Flat();
		flat.setFlatId(flatPayload.getFlatId());
		flat.setCost(flatPayload.getCost());
		flat.setFlatType(flatPayload.getFlatType());
		flat.setAvailability(flatPayload.getAvailability());
		flat.setFlatAddress(flatPayload.getFlatAddress());
		flat.setLandlord(landlord);
		Flat updatedFlat = iFlatService.updateFlat(flat);
		return new ResponseEntity<>(updatedFlat, HttpStatus.OK);
	}

}