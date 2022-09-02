package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.Flight;

public interface IFlightService {
	//CRUD	
	public List<Flight> listFlights();
		
	public Flight saveFlight(Flight flight);
	
	public Flight flightXID(Long id); 
			
	public Flight updateFlight(Flight flight); 
		
	public void deleteFlight(Long id);
	
	public Flight changeStatus(Long id);  //Change the flight status "logic delete"

}
