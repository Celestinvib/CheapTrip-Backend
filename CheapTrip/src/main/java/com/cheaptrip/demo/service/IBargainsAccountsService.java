package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.BargainsAccounts;

public interface IBargainsAccountsService {
	
	public List<BargainsAccounts> listBargainsAccounts();
	
	public List<BargainsAccounts> listBargainsAccountsBooked();
	
	public List<BargainsAccounts> findBookmarkedByAccount(Long accountId);
	
	public BargainsAccounts bargainsAccountsXID(Long id);
	
	public BargainsAccounts updateBargainsAccounts(BargainsAccounts bargainsAccounts);
		
	public void deleteBargainsAccounts(Long id);
	
}
