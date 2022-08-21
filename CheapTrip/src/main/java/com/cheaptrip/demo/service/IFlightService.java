package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.Flight;

public interface IFlightService {
	
	public List<Flight> listFlights(); //List All 
		
	public Flight saveFlight(Flight flight);//Save a new flight "CREATE"
	
	public Flight flightXID(Long id); //Read flight from a part "READ"
			
	public Flight updateFlight(Flight flight); //Update flight data "UPDATE"
	
	public Flight changeStatus(Long id); //Change the flight status "DELETE"
	
	public void deleteFlight(Long id);// Delete a flight via id "DELETE"
}
