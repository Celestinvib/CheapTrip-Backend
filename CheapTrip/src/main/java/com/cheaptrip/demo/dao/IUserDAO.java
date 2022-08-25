package com.cheaptrip.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheaptrip.demo.dto.User;


public interface IUserDAO extends JpaRepository<User, Long>{

	User findByName(String username);
		
}

