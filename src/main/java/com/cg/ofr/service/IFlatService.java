package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.FlatNotFoundException;

public interface IFlatService {

	public Flat addFlat(Flat flat);

	public Flat updateFlat(Flat flat) throws FlatNotFoundException;

	public void deleteFlat(String flatId) throws FlatNotFoundException;

	public Flat viewFlat(String id) throws FlatNotFoundException;

	public List<Flat> viewAllFlat();

	public List<Flat> viewAllFlatByCost(float cost, String availability);

}
