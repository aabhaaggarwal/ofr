package com.cg.ofr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.service.IFlatBookingService;

@RestController
public class FlatBookingController {
	
	@Autowired
	private IFlatBookingService iFlatBookingService;
	
	@GetMapping("/flatbooking/all")
	public List<FlatBooking> fetchAllFlatBooking() {
		List<FlatBooking> flatBookings = iFlatBookingService.viewAllFlatBooking();
		return flatBookings;
	}
	
	@GetMapping("/flatbooking/{fbId}")
	public ResponseEntity<Object> fetchFlatBookingById(@PathVariable("fbId") String id) {
			FlatBooking flatBooking = iFlatBookingService.viewFlatBooking(id);
			ResponseEntity<Object> responseEntity = new ResponseEntity<>(flatBooking,HttpStatus.OK);
			return responseEntity;
		
	}
	
	@DeleteMapping("/flatbooking/{fbId}")
	public ResponseEntity<Object> deleteFlatBooking(@PathVariable("fbId") String id) {
			iFlatBookingService.deleteFlatBooking(id);
			ResponseEntity<Object> responseEntity = new ResponseEntity<>("Flat Booking deleted successfully",HttpStatus.OK);
			return responseEntity;	
	}
	
	@PutMapping("/flatbooking/update")
	public ResponseEntity<FlatBooking> modifyProduct(@RequestBody FlatBooking flatBooking){
		FlatBooking updatedFlatBooking = iFlatBookingService.updateFlatBooking(flatBooking);
		ResponseEntity<FlatBooking> responseEntity = new ResponseEntity<>(updatedFlatBooking,HttpStatus.OK);
		return responseEntity;
	}

}
