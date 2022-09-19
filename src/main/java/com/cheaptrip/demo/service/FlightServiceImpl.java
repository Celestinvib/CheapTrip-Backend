package com.cheaptrip.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheaptrip.demo.dao.IFlightDAO;
import com.cheaptrip.demo.dto.Flight;

@Service
public class FlightServiceImpl implements IFlightService{
	//We use the methods of the iFlightDAO interface, it is as if we were instantiating.
	@Autowired
	IFlightDAO iFlightDAO;

	@Override
	public List<Flight> listFlights() {
		
		return iFlightDAO.findAll();
	}

	@Override
	public Flight saveFlight(Flight flight) {
		
		return iFlightDAO.save(flight);
	}

	@Override
	public Flight flightXID(String id) {
		
		return iFlightDAO.findById(id).get();
	}

	@Override
	public Flight updateFlight(Flight flight) {
		
		return iFlightDAO.save(flight);
	}

	@Override
	public Flight changeStatus(String id) {
		
		return iFlightDAO.findByStatus(id);
	}
	
	@Override
	public void deleteFlight(String id) {
		
		iFlightDAO.deleteById(id);
	}
}
