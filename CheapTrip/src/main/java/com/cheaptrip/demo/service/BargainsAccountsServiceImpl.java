package com.cheaptrip.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheaptrip.demo.dao.IBargainsAccountsDAO;
import com.cheaptrip.demo.dto.BargainsAccounts;

@Service
public class BargainsAccountsServiceImpl implements IBargainsAccountsService {
	
	@Autowired
	IBargainsAccountsDAO iBargainsUsersDAO;
	
	@Override
	public List<BargainsAccounts> listBargainsUsersbookmarked() {
		
		return iBargainsUsersDAO.findAll();
	}
	
	@Override
	public List<BargainsAccounts> listBargainsUsersbook() {
		
		return iBargainsUsersDAO.findAll();
	}

	@Override
	public BargainsAccounts updatebargainsUsers(BargainsAccounts bargainsUsers) {
		
		return iBargainsUsersDAO.save(bargainsUsers);
	}
	
	@Override
	public BargainsAccounts bargainsUsersXID(Long id) {
		
		return iBargainsUsersDAO.findById(id).get();
	}
	
	
	@Override
	public void deleteBargainsUsers(Long id) {
		
		iBargainsUsersDAO.deleteById(id);
	}
	
}
