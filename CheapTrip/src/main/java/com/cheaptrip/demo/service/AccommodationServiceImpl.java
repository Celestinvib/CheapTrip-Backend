package com.cheaptrip.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheaptrip.demo.dao.IAccommodationDAO;
import com.cheaptrip.demo.dto.Accommodation;

@Service
public class AccommodationServiceImpl implements IAccommodationService{

	//We use the methods of the iAccommodationDAO interface, it is as if we were instantiating.
	@Autowired
	IAccommodationDAO iAccommodationDAO;
	
	@Override
	public List<Accommodation> listAccommodations() {
		
		return iAccommodationDAO.findAll();
	}

	@Override
	public List<Accommodation> findByCategory(String category) {
		
		return iAccommodationDAO.findByCategory(category);	
	}

	@Override
	public List<Accommodation> filterByThisRatingOrUpper(double rating) {
		
		return iAccommodationDAO.filterByThisRatingOrUpper(rating);	
	}

	@Override
	public Accommodation saveAccommodation(Accommodation accommodation) {
		
		return iAccommodationDAO.save(accommodation);
	}

	@Override
	public Accommodation accommodationXID(Long id) {
		
		return iAccommodationDAO.findById(id).get();
	}

	@Override
	public Accommodation updateAccommodation(Accommodation accommodation) {
		
		return iAccommodationDAO.save(accommodation);
	}

	@Override
	public void deleteAccommodation(Long id) {
		
		iAccommodationDAO.deleteById(id);
	}
	
}
