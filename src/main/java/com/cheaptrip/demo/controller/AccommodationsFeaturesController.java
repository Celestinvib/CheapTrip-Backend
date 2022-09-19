package com.cheaptrip.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cheaptrip.demo.dto.AccommodationsFeatures;
import com.cheaptrip.demo.service.AccommodationsFeaturesServiceImpl;

@RestController
public class AccommodationsFeaturesController {
	
	@Autowired
	AccommodationsFeaturesServiceImpl accommodationsFeaturesServiceImpl;
	
	@GetMapping("/rasgos-alojamientos")
	public List<AccommodationsFeatures> listAccommodationsFeatures(){
		
		return accommodationsFeaturesServiceImpl.listAccommodationsFeatures();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/rasgos-alojamientos")
	public AccommodationsFeatures saveAccommodationFeatures(@RequestBody AccommodationsFeatures accommodationFeatures) {
		
		return accommodationsFeaturesServiceImpl.saveAccommodationsFeatures(accommodationFeatures);
	}
	
	@GetMapping("/rasgos-alojamientos/{id}")
	public AccommodationsFeatures accommodationFeaturesXID(@PathVariable(name="id") Long id) {
		
		AccommodationsFeatures accommodationsFeatures_xid= new AccommodationsFeatures();
		
		accommodationsFeatures_xid= accommodationsFeaturesServiceImpl.accommodationsFeaturesXID(id);
				
		return accommodationsFeatures_xid;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/rasgos-alojamientos/{id}")
	public AccommodationsFeatures updateAccommodation(@PathVariable(name="id")Long id,@RequestBody AccommodationsFeatures accommodation) {
		
		AccommodationsFeatures accommodationsFeaturesSelected= new AccommodationsFeatures();
		AccommodationsFeatures accommodationsFeaturesUpdated = new AccommodationsFeatures();
		
		accommodationsFeaturesSelected = accommodationsFeaturesServiceImpl.accommodationsFeaturesXID(id);
		
		accommodationsFeaturesSelected.setAccommodation(accommodation.getAccommodation());
		accommodationsFeaturesSelected.setFeature(accommodation.getFeature());
	
		accommodationsFeaturesUpdated = accommodationsFeaturesServiceImpl.updateAccommodationsFeatures(accommodationsFeaturesSelected);
				
		return accommodationsFeaturesUpdated;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/rasgos-alojamientos/{id}")
	public void deleteAccommodationFeatures(@PathVariable(name="id")Long id) {
		accommodationsFeaturesServiceImpl.deleteAccommodationsFeatures(id);
	}	
}
