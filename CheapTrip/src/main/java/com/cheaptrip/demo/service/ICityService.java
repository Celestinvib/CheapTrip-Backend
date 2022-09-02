package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.City;

public interface ICityService {
	
	//CRUD
	public List<City> listCities(); 	

	public City saveCity(City city);	

	public City cityByID(Long id); 		
	
	public City updateCity(City city);	

	public void deleteCity(Long id);	
}
