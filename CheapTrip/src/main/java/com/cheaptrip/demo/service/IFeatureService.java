package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.Feature;

public interface IFeatureService {
	
	//CRUD
	public List<Feature> listFeatures(); 			//List

	public Feature saveFeature(Feature feature);	//Save

	public Feature featureByID(int id); 			//Read

	public Feature updateFeature(Feature feature);	//Update

	public void deleteFeature(int id);				//Delete
}
