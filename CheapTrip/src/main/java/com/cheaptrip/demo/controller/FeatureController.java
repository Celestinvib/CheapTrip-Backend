package com.cheaptrip.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cheaptrip.demo.dto.Feature;
import com.cheaptrip.demo.service.FeatureServiceImpl;

@RestController
public class FeatureController {

	@Autowired
	FeatureServiceImpl featureServiceImpl;
	
	@GetMapping("/features")
	public List<Feature> listFeatures(){
		
		return featureServiceImpl.listFeatures();
	}
	
	@PostMapping("/features")
	public Feature saveFeature(@RequestBody Feature feature) {
		
		return featureServiceImpl.saveFeature(feature);
	}
	
	@GetMapping("/features/{id}")
	public Feature featureByID(@PathVariable(name="id") Long id) {
		
		Feature feature_byid= new Feature();
		
		feature_byid= featureServiceImpl.featureByID(id);
				
		return feature_byid;
	}
	
	@PutMapping("/features/{id}")
	public Feature updateFeature(@PathVariable(name="id")Long id,@RequestBody Feature feature) {
		
		Feature featureSelected= new Feature();
		Feature featureUpdated = new Feature();
		
		featureSelected = featureServiceImpl.featureByID(id);
		
		featureSelected.setName(feature.getName());
	
		featureUpdated = featureServiceImpl.updateFeature(featureSelected);
				
		return featureUpdated;
	}
	
	
	@DeleteMapping("/features/{id}")
	public void deleteFeature(@PathVariable(name="id")Long id) {
		featureServiceImpl.deleteFeature(id);
	}	
}
