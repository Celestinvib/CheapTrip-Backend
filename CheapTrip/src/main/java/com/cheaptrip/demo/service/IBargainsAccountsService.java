package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.BargainsAccounts;

public interface IBargainsAccountsService {
	
	public List<BargainsAccounts> listBargainsUsersbookmarked();
	
	public List<BargainsAccounts> listBargainsUsersbook();
	
	public BargainsAccounts bargainsUsersXID(Long id);
	
	public BargainsAccounts updatebargainsUsers(BargainsAccounts bargainsUsers);
		
	public void deleteBargainsUsers(Long id);
	
}
