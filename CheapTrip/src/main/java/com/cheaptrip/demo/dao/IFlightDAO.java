package com.cheaptrip.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheaptrip.demo.dto.Flight;

public interface IFlightDAO extends JpaRepository<Flight, String>{
	
	//Change the flight status
	public Flight findByStatus(String id);
}