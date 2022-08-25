package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.BargainsUsers;

public interface IBargainsUsersService {
	
	public List<BargainsUsers> listBargainsUsersbookmarked();
	
	public List<BargainsUsers> listBargainsUsersbook();
	
	public BargainsUsers bargainsUsersXID(Long id);
	
	public BargainsUsers updatebargainsUsers(BargainsUsers bargainsUsers);
	
	public BargainsUsers changeStatusBookmarked(Long id);
	
	public BargainsUsers changeStatusBook(Long id);
	
	public void deleteBargainsUsers(Long id);
	
}
