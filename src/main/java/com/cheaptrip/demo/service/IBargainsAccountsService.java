package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.BargainsAccounts;

public interface IBargainsAccountsService {
	
	//CRUD
	public List<BargainsAccounts> listBargainsAccounts();
	
	public BargainsAccounts bargainsAccountsXID(Long id);
	
	public BargainsAccounts updateBargainsAccounts(BargainsAccounts bargainsAccounts);
		
	public void deleteBargainsAccounts(Long id);
	
	public List<BargainsAccounts> listBargainsAccountsBooked(); //List the Accommodations has been booked by an account
	
	public List<BargainsAccounts> findBookmarkedByAccount(Long accountId); //List the Accommodations has been bookmarked by an account
	
}
