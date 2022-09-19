package com.cg.ofr.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.model.FlatPayload;
import com.cg.ofr.service.IFlatService;
import com.cg.ofr.service.ILandlordService;

@RestController
public class FlatController {
    
    @Autowired
    private IFlatService iFlatService;
    
    @Autowired
    private ILandlordService iLandlordService;
    
    @PostMapping("/flat/save")
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
        ResponseEntity<Flat> responseEntity=new ResponseEntity<>(newFlat,HttpStatus.CREATED);
        return responseEntity;
    }
    
    @GetMapping("/flat/all")
    public List<Flat> fetchAllFlat(){
        List<Flat> flat=iFlatService.viewAllFlat();
        return flat;
    }
  
}