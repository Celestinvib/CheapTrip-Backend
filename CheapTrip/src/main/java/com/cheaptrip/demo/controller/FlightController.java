package com.cheaptrip.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cheaptrip.demo.dto.Flight;
import com.cheaptrip.demo.service.FlightServiceImpl;



@RestController
public class FlightController {

	@Autowired
	FlightServiceImpl flightServiceImpl;
	
	@GetMapping("/vuelos")
	public List<Flight> listFlights(){
		
		return flightServiceImpl.listFlights();
	}
	
	@PostMapping("/vuelos")
	public Flight saveFlight(@RequestBody Flight flight) {
		
		return flightServiceImpl.saveFlight(flight);
	}
	
	@GetMapping("/vuelos/{id}")
	public Flight flightXID(@PathVariable(name="id") Long id) {
		
		Flight flight_xid= new Flight();
		
		flight_xid= flightServiceImpl.flightXID(id);
				
		return flight_xid;
	}
	
	@PutMapping("/vuelos/{id}")
	public Flight updateFlight(@PathVariable(name="id")Long id,@RequestBody Flight flight) {
		
		Flight flightSelected= new Flight();
		Flight flightUpdated = new Flight();
		
		flightSelected = flightServiceImpl.flightXID(id);
		
		flightSelected.setArrival_date(flight.getArrival_date());
		flightSelected.setDeparture_date(flight.getDeparture_date());
		flightSelected.setOrigin(flight.getOrigin());
		flightSelected.setDestination(flight.getDestination());
	
		flightUpdated = flightServiceImpl.updateFlight(flightSelected);
				
		return flightUpdated;
	}
	
	@DeleteMapping("/vuelos/cambiar-estado/{id}")
	public void changeStatusFlight(@PathVariable(name="id")Long id) {
		
		Flight flight = flightXID(id);		
		
		if(flight.getStatus() == 0) { 
			flight.setStatus(1);
		}else {
			flight.setStatus(0);	
		}
	}	
	
	@DeleteMapping("/vuelos/{id}")
	public void deleteFlight(@PathVariable(name="id")Long id) {
		flightServiceImpl.deleteFlight(id);
	}	
}
