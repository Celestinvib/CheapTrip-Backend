package com.cheaptrip.demo.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cheaptrip.demo.dto.Bargain;
import com.cheaptrip.demo.service.BargainServiceImpl;

@RestController
public class BargainController {
	@Autowired
	BargainServiceImpl bargainServiceImpl;
	
	@GetMapping("/chollos")
	public List<Bargain> listBargains(){
		List<Bargain> bargains =  bargainServiceImpl.listBargains();
		List<Bargain> activeBargains = new ArrayList<>() ;
		
		for (int i = 0; i < bargains.size(); i++) { 
			if (bargains.get(i).getStatus() == 1) { //if a bargain is active
				activeBargains.add(bargains.get(i)); //It's added to the List that will be returned 
			}
		}
		
		return activeBargains;
	}
	
	@GetMapping("/todos/chollos")
	public List<Bargain> listAllBargains(){
		return bargainServiceImpl.listBargains();
	}
	
	@GetMapping("/chollos/expiran-pronto")
	public List<Bargain> bargainsExpiringSoon(){
		List<Bargain> bargains =  bargainServiceImpl.listBargains();
		List<Bargain> bargainsExpiring = new ArrayList<>() ;
		
		java.sql.Date now = new java.sql.Date( new java.util.Date().getTime() );
		java.sql.Date nextWeek= new java.sql.Date( now.getTime() + 168*60*60*1000);
				
		for (int i = 0; i < bargains.size(); i++) { 
			if (bargains.get(i).getExpiration_date().compareTo(nextWeek) <= 0 ) { //if a bargain expire one week from now
				bargainsExpiring.add(bargains.get(i)); //It's added to the List that will be returned 
			}
		}
		
		return bargainsExpiring;
	}
	
	@GetMapping("/chollos/maxprecio/{precio}")
	public List<Bargain> listByMaxPrice(@PathVariable(name="precio") Long precio){
		
		List<Bargain> bargains = listBargains();
		List<Bargain> bargainsWDesiredPrice = new ArrayList<>() ;
		
		for (int i = 0; i < bargains.size(); i++) { 
			if (bargains.get(i).getPrice() <= precio) { //if a bargain has the same or less price than the desired one 
				bargainsWDesiredPrice.add(bargains.get(i)); //It's added to the List that will be returned 
			}
		}
		
		return bargainsWDesiredPrice;
	}
	
	@GetMapping("/chollos/alojamiento/{id-alojamiento}")
	public List<Bargain> listByAccommodation(@PathVariable(name="id-alojamiento") Long idAlojamiento){
		
		List<Bargain> bargains = listBargains();
		List<Bargain> bargainsWAccomodaton = new ArrayList<>() ;
		
		for (int i = 0; i < bargains.size(); i++) { 
			if (bargains.get(i).getAccommodation().getId() == idAlojamiento) { //if a bargain has the same accomodation id as the one specified 
				bargainsWAccomodaton.add(bargains.get(i)); //It's added to the List that will be returned 
			}
		}
		
		return bargainsWAccomodaton;
	}	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/chollos")
	public Bargain saveBargain(@RequestBody Bargain bargain) {
		
		bargain.setStatus(1); //Sets the bargain status to 1 (active bargain)
		return bargainServiceImpl.saveBargain(bargain);
	}
	
	@GetMapping("/chollos/{id}")
	public Bargain bargainXID(@PathVariable(name="id") Long id) {
		
		Bargain bargain_xid= new Bargain();
		
		bargain_xid= bargainServiceImpl.bargainXID(id);
				
		return bargain_xid;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/chollos/{id}")
	public Bargain updateBargain(@PathVariable(name="id")Long id,@RequestBody Bargain bargain) {
		
		Bargain bargainSelected= new Bargain();
		Bargain bargainUpdated = new Bargain();
		
		bargainSelected = bargainServiceImpl.bargainXID(id);
		
		bargainSelected.setTitle(bargain.getTitle());
		bargainSelected.setImage(bargain.getImage());
		bargainSelected.setPrice(bargain.getPrice());
		bargainSelected.setDescription(bargain.getDescription());
		bargainSelected.setExpiration_date(bargain.getExpiration_date());
		bargainSelected.setAccommodation(bargain.getAccommodation());
		bargainSelected.setOutbound_flight(bargain.getOutbound_flight());
		bargainSelected.setReturn_flight(bargain.getReturn_flight());
	
		bargainUpdated = bargainServiceImpl.updateBargain(bargainSelected);
				
		return bargainUpdated;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/chollos/cambiar-estado/{id}")
	public Bargain changeStatusBargain(@PathVariable(name="id")Long id) {
		
		Bargain bargain = bargainXID(id);
		Bargain bargainUpdated = new Bargain();
		
		if(bargain.getStatus() == 0) { 
			bargain.setStatus(1);
		}else {
			bargain.setStatus(0);	
		}
		bargainUpdated = bargainServiceImpl.updateBargain(bargain);

	        return bargainUpdated;
	}	
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/chollos/{id}")
	public void deleteBargain(@PathVariable(name="id")Long id) {
		bargainServiceImpl.deleteBargain(id);
	}	
}
