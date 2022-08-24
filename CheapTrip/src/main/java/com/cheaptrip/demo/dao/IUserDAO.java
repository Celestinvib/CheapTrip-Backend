package com.cheaptrip.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheaptrip.demo.dto.User;


public interface IUserDAO extends JpaRepository<User, Long>{

		//List the Users by its categories by category
		public List<User> findByCategory(String category); 
		
		//List the Users by a rating and its upper values 
		public List<User> filterByThisRatingOrUpper(double rating);
		
		
		//Change the User status
		public User changeStatus(Long id);
		
}

