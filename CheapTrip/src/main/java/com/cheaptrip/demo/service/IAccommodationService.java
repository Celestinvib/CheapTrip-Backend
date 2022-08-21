package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.Accommodation;

public interface IAccommodationService {
			
			public List<Accommodation> listAccommodations(); //List All 
			
			public List<Accommodation> findByCategory(String category); //List the Accommodations by its categories by category

			public List<Accommodation> filterByThisRatingOrUpper(double rating); //List the Accommodations by a rating and its upper values 

			public Accommodation saveAccommodation(Accommodation accommodation);//Save a new bargain "CREATE"
			
			public Accommodation accommodationXID(Long id); //Read bargain from a part "READ"
					
			public Accommodation updateAccommodation(Accommodation accommodation); //Update bargain data "UPDATE"
			
			public void deleteAccommodation(Long id);// Delete a bargain via id "DELETE"
}
