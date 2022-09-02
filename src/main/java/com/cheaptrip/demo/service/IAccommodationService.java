package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.Accommodation;

public interface IAccommodationService {
			
			//CRUD
			public List<Accommodation> listAccommodations();
				
			public Accommodation saveAccommodation(Accommodation accommodation);
			
			public Accommodation accommodationXID(Long id);
					
			public Accommodation updateAccommodation(Accommodation accommodation); 
				
			public void deleteAccommodation(Long id);
			
			public List<Accommodation> findByCategory(String category); //List the Accommodations by its categories by category

			public List<Accommodation> filterByThisRatingOrUpper(double rating); //List the Accommodations by a rating and its upper values 
			
			public List<Accommodation> findByCity(String cityName); //List the Accommodations by a city
			
			public Accommodation changeStatus(Long id); //Change the accommodation status "logic delete"

}
