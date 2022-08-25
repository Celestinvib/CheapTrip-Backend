package com.cheaptrip.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheaptrip.demo.dto.AccommodationsFeatures;


public interface IAccommodationsFeaturesDAO extends JpaRepository<AccommodationsFeatures, Long>{

	
}
