package com.cheaptrip.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheaptrip.demo.dao.IBargainDAO;
import com.cheaptrip.demo.dto.Bargain;

@Service
public class BargainServiceImpl implements IBargainService{
	//We use the methods of the iBargainDAO interface, it is as if we were instantiating.
	@Autowired
	IBargainDAO iBargainDAO;
	
	@Override
	public List<Bargain> listBargains() {
		
		return iBargainDAO.findAll();
	}

	@Override
	public List<Bargain> listByMaxPrice(double price) {
		
		return iBargainDAO.findByPrice(price);	
	}

	@Override
	public Bargain saveBargain(Bargain bargain) {
		
		return iBargainDAO.save(bargain);
	}

	@Override
	public Bargain bargainXID(Long id) {
		
		return iBargainDAO.findById(id).get();
	}

	@Override
	public Bargain updateBargain(Bargain bargain) {
		
		return iBargainDAO.save(bargain);
	}
	
	@Override
	public Bargain changeStatus(Long id) {
		
		return iBargainDAO.findByStatus(id);
	}
	
	@Override
	public void deleteBargain(Long id) {
		
		iBargainDAO.deleteById(id);
	}

}
