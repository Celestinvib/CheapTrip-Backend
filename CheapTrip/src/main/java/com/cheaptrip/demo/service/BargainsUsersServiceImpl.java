package com.cheaptrip.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheaptrip.demo.dao.IBargainsUsersDAO;
import com.cheaptrip.demo.dto.BargainsUsers;

@Service
public class BargainsUsersServiceImpl implements IBargainsUsersService {
	
	@Autowired
	IBargainsUsersDAO iBargainsUsersDAO;
	
	@Override
	public List<BargainsUsers> listBargainsUsersbookmarked() {
		
		return iBargainsUsersDAO.findAll();
	}
	
	@Override
	public List<BargainsUsers> listBargainsUsersbook() {
		
		return iBargainsUsersDAO.findAll();
	}

	@Override
	public BargainsUsers updatebargainsUsers(BargainsUsers bargainsUsers) {
		
		return iBargainsUsersDAO.save(bargainsUsers);
	}
	
	@Override
	public BargainsUsers bargainsUsersXID(Long id) {
		
		return iBargainsUsersDAO.findById(id).get();
	}
	
	
	@Override
	public void deleteBargainsUsers(Long id) {
		
		iBargainsUsersDAO.deleteById(id);
	}
	
}
