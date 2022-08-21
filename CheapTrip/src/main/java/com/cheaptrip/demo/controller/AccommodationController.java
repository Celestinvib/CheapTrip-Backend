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

import com.cheaptrip.demo.dto.Accommodation;
import com.cheaptrip.demo.service.AccommodationServiceImpl;

@RestController
public class AccommodationController {
	
	@Autowired
	AccommodationServiceImpl accommodationServiceImpl;
	
	@GetMapping("/alojamientos")
	public List<Accommodation> listAccommodations(){
		
		return accommodationServiceImpl.listAccommodations();
	}
	
	@PostMapping("/alojamientos")
	public Accommodation saveAccommodation(@RequestBody Accommodation accommodation) {
		
		return accommodationServiceImpl.saveAccommodation(accommodation);
	}
	
	@GetMapping("/alojamientos/{id}")
	public Accommodation accommodationtXID(@PathVariable(name="id") Long id) {
		
		Accommodation accommodation_xid= new Accommodation();
		
		accommodation_xid= accommodationServiceImpl.accommodationXID(id);
				
		return accommodation_xid;
	}
	
	@PutMapping("/alojamientos/{id}")
	public Accommodation updateAccommodation(@PathVariable(name="id")Long id,@RequestBody Accommodation accommodation) {
		
		Accommodation accommodationSelected= new Accommodation();
		Accommodation accommodationUpdated = new Accommodation();
		
		accommodationSelected = accommodationServiceImpl.accommodationXID(id);
		
		accommodationSelected.setName(accommodation.getName());
		accommodationSelected.setAddress(accommodation.getAddress());
		accommodationSelected.setCategory(accommodation.getCategory());
		accommodationSelected.setLatitude(accommodation.getLatitude());
		accommodationSelected.setLongitude(accommodation.getLongitude());
		accommodationSelected.setRating(accommodation.getRating());
		accommodationSelected.setCity(accommodation.getCity());
	
		accommodationUpdated = accommodationServiceImpl.updateAccommodation(accommodationSelected);
				
		return accommodationUpdated;
	}
	
	
	@DeleteMapping("/alojamientos/{id}")
	public void deleteAccommodation(@PathVariable(name="id")Long id) {
		accommodationServiceImpl.deleteAccommodation(id);
	}	
}
