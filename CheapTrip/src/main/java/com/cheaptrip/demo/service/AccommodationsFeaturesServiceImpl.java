package com.cheaptrip.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheaptrip.demo.dao.IAccommodationsFeaturesDAO;
import com.cheaptrip.demo.dto.AccommodationsFeatures;

@Service
public class AccommodationsFeaturesServiceImpl implements IAccommodationsFeaturesService{

	//We use the methods of the iAccommodationDAO interface, it is as if we were instantiating.
	@Autowired
	IAccommodationsFeaturesDAO iAccommodationsFeaturesDAO;
	
	@Override
	public List<AccommodationsFeatures> listAccommodationsFeatures() {
		
		return iAccommodationsFeaturesDAO.findAll();
	}

	@Override
	public AccommodationsFeatures saveAccommodationsFeatures(AccommodationsFeatures accommodationFeatures) {
		
		return iAccommodationsFeaturesDAO.save(accommodationFeatures);
	}

	@Override
	public AccommodationsFeatures accommodationsFeaturesXID(Long id) {
		
		return iAccommodationsFeaturesDAO.findById(id).get();
	}

	@Override
	public AccommodationsFeatures updateAccommodationsFeatures(AccommodationsFeatures accommodationFeatures) {
		
		return iAccommodationsFeaturesDAO.save(accommodationFeatures);
	}

	@Override
	public void deleteAccommodationsFeatures(Long id) {
		
		iAccommodationsFeaturesDAO.deleteById(id);
	}
	
}
