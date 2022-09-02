package com.cheaptrip.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		
		return bargainServiceImpl.listBargains();
	}
	
	@GetMapping("/chollos/maxprecio/{precio}")
	public List<Bargain> listByMaxPrice(@PathVariable(name="precio") Long precio){
		
		List<Bargain> bargains = listBargains();
		List<Bargain> bargainsWDesiredPrice = new ArrayList<>() ;
		
		for (int i = 0; i < bargains.size(); i++) { 
			if (bargains.get(i).getPrice() <= precio) { //if a bargain has the same or less price than the desired one 
				bargainsWDesiredPrice.add(bargains.get(i)); //Is added to the List that will be returned 
			}
		}
		
		return bargainsWDesiredPrice;
	}
	
	@PostMapping("/chollos")
	public Bargain saveBargain(@RequestBody Bargain bargain) {
		
		return bargainServiceImpl.saveBargain(bargain);
	}
	
	@GetMapping("/chollos/{id}")
	public Bargain bargainXID(@PathVariable(name="id") Long id) {
		
		Bargain bargain_xid= new Bargain();
		
		bargain_xid= bargainServiceImpl.bargainXID(id);
				
		return bargain_xid;
	}
	
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
	
	@DeleteMapping("/chollos/cambiar-estado/{id}")
	public void changeStatusBargain(@PathVariable(name="id")Long id) {
		
		Bargain bargain = bargainXID(id);		
		
		if(bargain.getStatus() == 0) { 
			bargain.setStatus(1);
		}else {
			bargain.setStatus(0);	
		}
	}	
	
	
	@DeleteMapping("/chollos/{id}")
	public void deleteBargain(@PathVariable(name="id")Long id) {
		bargainServiceImpl.deleteBargain(id);
	}	
}
