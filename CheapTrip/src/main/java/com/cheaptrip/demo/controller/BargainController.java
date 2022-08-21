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
	
	@PutMapping("/alojamientos/{id}")
	public Bargain updateBargain(@PathVariable(name="id")Long id,@RequestBody Bargain bargain) {
		
		Bargain bargainSelected= new Bargain();
		Bargain bargainUpdated = new Bargain();
		
		bargainSelected = bargainServiceImpl.bargainXID(id);
		
		bargainSelected.setTitle(bargain.getTitle());
		bargainSelected.setImage(bargain.getImage());
		bargainSelected.setPrice(bargain.getPrice());
		bargainSelected.setDescription(bargain.getDescription());
		bargainSelected.setExpiration_date(bargain.getExpiration_date());
		bargainSelected.setAccomodation(bargain.getAccomodation());
		bargainSelected.setOutbound_flight(bargain.getOutbound_flight());
		bargainSelected.setReturn_flight(bargain.getReturn_flight());
	
		bargainUpdated = bargainServiceImpl.updateBargain(bargainSelected);
				
		return bargainUpdated;
	}
	
	
	@DeleteMapping("/chollos/{id}")
	public void deleteBargain(@PathVariable(name="id")Long id) {
		bargainServiceImpl.deleteBargain(id);
	}	
}