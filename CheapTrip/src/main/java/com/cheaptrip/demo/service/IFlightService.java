package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.Flight;

public interface IFlightService {
	//CRUD	
	public List<Flight> listFlights();
		
	public Flight saveFlight(Flight flight);
	
	public Flight flightXID(String id); 
			
	public Flight updateFlight(Flight flight); 
		
	public void deleteFlight(String id);
	
	public Flight changeStatus(String id);  //Change the flight status "logic delete"

}
