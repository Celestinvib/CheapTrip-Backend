package com.cheaptrip.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheaptrip.demo.dto.Flight;

public interface IFlightDAO extends JpaRepository<Flight, Long>{
	
	//Change the flight status
	public Flight changeStatus(Long id);
}