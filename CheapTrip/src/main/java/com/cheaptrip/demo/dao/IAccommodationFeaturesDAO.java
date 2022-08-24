package com.cheaptrip.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheaptrip.demo.dto.AccommodationFeatures;


public interface IAccommodationFeaturesDAO extends JpaRepository<AccommodationFeatures, Long>{

		//List the AccommodationFeatures by its categories by category
		public List<AccommodationFeatures> findByCategory(String category); 
		
		//List the AccommodationFeatures by a rating and its upper values 
		public List<AccommodationFeatures> filterByThisRatingOrUpper(double rating);
		
		
		//Change the AccommodationFeatures status
		public AccommodationFeatures changeStatus(Long id);
		
}
