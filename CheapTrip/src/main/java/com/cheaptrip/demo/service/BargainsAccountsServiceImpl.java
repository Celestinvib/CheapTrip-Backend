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
	public List<BargainsAccounts> listBargainsAccounts() {
		
		return iBargainsUsersDAO.findAll();
	}
	
	@Override
	public List<BargainsAccounts> listBargainsAccountsBooked() {
		
		return iBargainsUsersDAO.findAll();
	}

	@Override
	public List<BargainsAccounts> findBookmarkedByAccount(Long accountId) {

		return iBargainsUsersDAO.findBookmarkedByAccount(accountId);
	}
	
	@Override
	public BargainsAccounts updateBargainsAccounts(BargainsAccounts bargainsUsers) {
		
		return iBargainsUsersDAO.save(bargainsUsers);
	}
	
	@Override
	public BargainsAccounts bargainsAccountsXID(Long id) {
		
		return iBargainsUsersDAO.findById(id).get();
	}
	
	
	@Override
	public void deleteBargainsAccounts(Long id) {
		
		iBargainsUsersDAO.deleteById(id);
	}
	
}
