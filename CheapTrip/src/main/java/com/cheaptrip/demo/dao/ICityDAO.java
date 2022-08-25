package com.cheaptrip.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheaptrip.demo.dto.City;

public interface ICityDAO extends JpaRepository<City, Long>{
	
}
