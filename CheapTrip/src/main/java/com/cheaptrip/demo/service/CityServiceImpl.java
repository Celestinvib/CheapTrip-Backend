package com.cheaptrip.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheaptrip.demo.dao.ICityDAO;
import com.cheaptrip.demo.dto.City;

@Service
public class CityServiceImpl implements ICityService{

	@Autowired
	ICityDAO iCityDAO;
	
	@Override
	public List<City> listCities() {
		return iCityDAO.findAll();
	}

	@Override
	public City saveCity(City city) {
		return iCityDAO.save(city);
	}

	@Override
	public City cityByID(Long id) {
		return iCityDAO.findById(id).get();
	}

	@Override
	public City updateCity(City city) {
		return iCityDAO.save(city);
	}

	@Override
	public void deleteCity(Long id) {
		iCityDAO.deleteById(id);		
	}

}
