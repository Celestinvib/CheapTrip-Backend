package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.AccommodationsFeatures;

public interface IAccommodationsFeaturesService {
	
	
	//CRUD
	public List<AccommodationsFeatures> listAccommodationsFeatures(); 

	public AccommodationsFeatures saveAccommodationsFeatures(AccommodationsFeatures accommodationFeatures);
	
	public AccommodationsFeatures accommodationsFeaturesXID(Long id);
			
	public AccommodationsFeatures updateAccommodationsFeatures(AccommodationsFeatures accommodationFeatures);
	
	public void deleteAccommodationsFeatures(Long id);

}

