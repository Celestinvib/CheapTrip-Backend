package com.cheaptrip.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheaptrip.demo.dto.Bargain;

public interface IBargainDAO extends JpaRepository<Bargain, Long>{
	
	//List the Bargains by their prices
	public List<Bargain> findByPrice (double price); 
	
	//Change the bargain status
	public Bargain findByStatus(Long id);
}