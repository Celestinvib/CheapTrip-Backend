package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.AccommodationsFeatures;

public interface IAccommodationsFeaturesService {
	
	public List<AccommodationsFeatures> listAccommodationsFeatures(); //List All 

	public AccommodationsFeatures saveAccommodationsFeatures(AccommodationsFeatures accommodationFeatures);//Save a new bargain "CREATE"
	
	public AccommodationsFeatures accommodationsFeaturesXID(Long id); //Read bargain from a part "READ"
			
	public AccommodationsFeatures updateAccommodationsFeatures(AccommodationsFeatures accommodationFeatures); //Update bargain data "UPDATE"
	
	public void deleteAccommodationsFeatures(Long id);// Delete a bargain via id "DELETE"

}

