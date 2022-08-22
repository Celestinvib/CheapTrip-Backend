package com.cheaptrip.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheaptrip.demo.dto.Accommodation;



public interface IAccommodationDAO extends JpaRepository<Accommodation, Long>{

		//List the Accommodations by its categories by category
		public List<Accommodation> findByCategory(String category); 
		
		//List the Accommodations by a rating and its upper values 
		public List<Accommodation> filterByThisRatingOrUpper(double rating);
		
		
		//Change the accommodation status
		public Accommodation changeStatus(Long id);
		
}
