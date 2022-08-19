package com.cheaptrip.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightDAO extends JpaRepository<Object, Long>{
	/**
	 * CHANGE OBJECT TO FLIGHT
	 */
}