package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.Feature;

public interface IFeatureService {
	
	//CRUD
	public List<Feature> listFeatures(); 			

	public Feature saveFeature(Feature feature);	

	public Feature featureByID(Long id); 			

	public Feature updateFeature(Feature feature);	

	public void deleteFeature(Long id);				
}
