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

import com.cheaptrip.demo.dto.City;
import com.cheaptrip.demo.service.CityServiceImpl;

@RestController
public class CityController {

	@Autowired
	CityServiceImpl cityServiceImpl;
	
	@GetMapping("/ciudades")
	public List<City> listCitys(){
		
		return cityServiceImpl.listCities();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/ciudades")
	public City saveCity(@RequestBody City city) {
		
		return cityServiceImpl.saveCity(city);
	}
	
	@GetMapping("/ciudades/{id}")
	public City cityByID(@PathVariable(name="id") Long id) {
		
		City city_byid= new City();
		
		city_byid= cityServiceImpl.cityByID(id);
				
		return city_byid;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/ciudades/{id}")
	public City updateCity(@PathVariable(name="id")Long id,@RequestBody City city) {
		
		City citySelected= new City();
		City cityUpdated = new City();
		
		citySelected = cityServiceImpl.cityByID(id);
		
		citySelected.setName(city.getName());
	
		cityUpdated = cityServiceImpl.updateCity(citySelected);
				
		return cityUpdated;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/ciudades/{id}")
	public void deleteCity(@PathVariable(name="id")Long id) {
		cityServiceImpl.deleteCity(id);
	}	
}
