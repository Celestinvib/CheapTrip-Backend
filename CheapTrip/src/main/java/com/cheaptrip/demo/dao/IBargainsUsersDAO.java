package com.cheaptrip.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheaptrip.demo.dto.BargainsUsers;


public interface IBargainsUsersDAO extends JpaRepository<BargainsUsers, Long>{

		//List the BargainsUsers by its categories by category
		public List<BargainsUsers> findByCategory(String category); 
		
		//List the BargainsUsers by a rating and its upper values 
		public List<BargainsUsers> filterByThisRatingOrUpper(double rating);
		
		
		//Change the BargainsUsers status
		public BargainsUsers changeStatus(Long id);
		
}

