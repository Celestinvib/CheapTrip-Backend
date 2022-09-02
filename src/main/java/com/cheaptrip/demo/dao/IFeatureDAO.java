package com.cheaptrip.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheaptrip.demo.dto.Feature;

public interface IFeatureDAO extends JpaRepository<Feature, Long>{
	
}
