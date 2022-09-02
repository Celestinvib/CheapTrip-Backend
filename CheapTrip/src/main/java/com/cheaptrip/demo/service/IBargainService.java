package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.Bargain;


public interface IBargainService {
		
		//CRUD
		public List<Bargain> listBargains(); 
				
		public Bargain saveBargain(Bargain bargain);
		
		public Bargain bargainXID(Long id); 
				
		public Bargain updateBargain(Bargain bargain); 
		
		public void deleteBargain(Long id);
		
		public List<Bargain> listByMaxPrice(double price);  // List all the bargains by a setted max price
		
		public Bargain changeStatus(Long id); //Change the bargain status "Logic delete"
}
