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
		ResponseEntity<Flat> responseEntity = new ResponseEntity<>(newFlat, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/all")
	public List<Flat> fetchAllFlat() {
		List<Flat> flat = iFlatService.viewAllFlat();
		return flat;
	}

	@GetMapping("/{fId}")
	public ResponseEntity<Object> fetchFlatById(@PathVariable("fId") String flatId) {
		Flat flat = iFlatService.viewFlat(flatId);
		ResponseEntity<Object> responseEntity = new ResponseEntity<>(flat, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/{fId}")
	public ResponseEntity<String> deleteFlatById(@PathVariable("fId") String flatId) {
		iFlatService.deleteFlat(flatId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Flat deleted successfully", HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/{fCost}/available")
	public ResponseEntity<Object> fetchFlatByCost(@PathVariable("fCost") float cost) {
		List<Flat> flats = iFlatService.viewAllFlatByCost(cost, "Available");
		ResponseEntity<Object> responseEntity = new ResponseEntity<>(flats, HttpStatus.OK);
		return responseEntity;
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
		ResponseEntity<Flat> responseEntity = new ResponseEntity<>(updatedFlat, HttpStatus.OK);
		return responseEntity;
	}

}