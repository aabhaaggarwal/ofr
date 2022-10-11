package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.FlatNotFoundException;

public interface IFlatService {

	public Flat addFlat(Flat flat);

	public Flat updateFlat(Flat flat) throws FlatNotFoundException;

	public void deleteFlat(int flatId) throws FlatNotFoundException;

	public Flat viewFlat(int id) throws FlatNotFoundException;

	public List<Flat> viewAllFlat();

	public List<Flat> viewAllFlatByCost(float mincost,float maxcost);
	
	public List<Flat> viewAllFlatByCity(String city);
	
	public List<Flat> viewAllFlatByAvailability();
	
	public List<Flat> viewAllFlatByType(String type);
	
	public List<Flat> viewAllByStatus(String status);
	
	public List<Flat> viewAllByApproval(String status);

	public List<Flat> viewAllByLandlord(int id);

}
