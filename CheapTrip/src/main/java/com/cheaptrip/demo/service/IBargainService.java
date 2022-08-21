package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.Bargain;


public interface IBargainService {
		
		public List<Bargain> listBargains(); //List All 
		
		public List<Bargain> listByMaxPrice(double price); //List All the bargains that have the price passed by parameter or a lower price
		
		public Bargain saveBargain(Bargain bargain);//Save a new bargain "CREATE"
		
		public Bargain bargainXID(Long id); //Read bargain from a part "READ"
				
		public Bargain updateBargain(Bargain bargain); //Update bargain data "UPDATE"
		
		public void deleteBargain(Long id);// Delete a bargain via id "DELETE"
}
