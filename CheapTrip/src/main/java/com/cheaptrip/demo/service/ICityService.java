package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.City;

public interface ICityService {
	
	//CRUD
	public List<City> listCities(); 	//List

	public City saveCity(City city);	//Save

	public City cityByID(int id); 		//Read

	public City updateCity(City city);	//Update

	public void deleteCity(int id);		//Delete
}
