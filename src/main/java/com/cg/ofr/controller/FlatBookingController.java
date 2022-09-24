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
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.model.FlatBookingPayload;
import com.cg.ofr.service.IFlatBookingService;
import com.cg.ofr.service.IFlatService;
import com.cg.ofr.service.ITenantService;

@RestController
@RequestMapping("/flatbooking")
public class FlatBookingController {

	@Autowired
	private IFlatBookingService iFlatBookingService;
	@Autowired
	private IFlatService iFlatService;
	@Autowired
	private ITenantService iTenantService;

	@GetMapping("/all")
	public List<FlatBooking> fetchAllFlatBooking() {
		 return iFlatBookingService.viewAllFlatBooking();
		
	}

	@GetMapping("/{fbId}")
	public ResponseEntity<Object> fetchFlatBookingById(@PathVariable("fbId") int id) {
		FlatBooking flatBooking = iFlatBookingService.viewFlatBooking(id);
		return new ResponseEntity<>(flatBooking, HttpStatus.OK);
		

	}

	@DeleteMapping("/{fbId}")
	public ResponseEntity<Object> deleteFlatBooking(@PathVariable("fbId") int id) {
		iFlatBookingService.deleteFlatBooking(id);
		return new ResponseEntity<>("Flat Booking deleted successfully",
				HttpStatus.OK);
	
	}

	@PutMapping("/update")
	public ResponseEntity<FlatBooking> modifyProduct(@RequestBody FlatBookingPayload flatBookingPayload) {
		Flat flat = iFlatService.viewFlat(flatBookingPayload.getFlatId());
	    Tenant tenant = iTenantService.viewTenant(flatBookingPayload.getTenantId());
		FlatBooking flatBooking = new FlatBooking();
		flatBooking.setBookingNo(flatBookingPayload.getBookingNo());
		flatBooking.setBookingFrom(flatBookingPayload.getBookingFrom());
		flatBooking.setBookingTo(flatBookingPayload.getBookingTo());
		flatBooking.setMembers(flatBookingPayload.getMembers());
		flatBooking.setFlat(flat);
		flatBooking.setTenant(tenant);
		FlatBooking updatedFlatBooking = iFlatBookingService.updateFlatBooking(flatBooking);
		return new ResponseEntity<>(updatedFlatBooking, HttpStatus.OK);
	
	}

	@PostMapping("/book")
	public ResponseEntity<FlatBooking> addFlatBooking(@RequestBody FlatBookingPayload flatBookingPayload) {
		Flat flat = iFlatService.viewFlat(flatBookingPayload.getFlatId());
		Tenant tenant = iTenantService.viewTenant(flatBookingPayload.getTenantId());
		FlatBooking flatBooking = new FlatBooking();
		flatBooking.setBookingNo(flatBookingPayload.getBookingNo());
		flatBooking.setBookingFrom(flatBookingPayload.getBookingFrom());
		flatBooking.setBookingTo(flatBookingPayload.getBookingTo());
		flatBooking.setMembers(flatBookingPayload.getMembers());
		flatBooking.setFlat(flat);
		flatBooking.setTenant(tenant);
		FlatBooking newFlatBooking = iFlatBookingService.addFlatBooking(flatBooking);
		return new ResponseEntity<>(newFlatBooking, HttpStatus.CREATED);
	
	}

}
