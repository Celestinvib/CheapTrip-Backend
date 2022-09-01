package com.cheaptrip.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cheaptrip.demo.dto.BargainsAccounts;
import com.cheaptrip.demo.service.BargainsAccountsServiceImpl;

public class BargainsAccountsController {
	
	@Autowired
	BargainsAccountsServiceImpl bargainsUsersServiceImpl;
	
	@GetMapping("/chollosfavoritos")
	public List<BargainsAccounts> listBargainsUsersbookmarked() {
		
		return bargainsUsersServiceImpl.listBargainsUsersbookmarked();
	}
	
	@GetMapping("/chollosreservados")
	public List<BargainsAccounts> listBargainsUsersbook() {
		
		return bargainsUsersServiceImpl.listBargainsUsersbook();
	}
	
	@GetMapping("/chollos-usuario/{id}")
	public BargainsAccounts bargainsUsersXID(@PathVariable(name="id") Long id) {
		
		BargainsAccounts bargainsUsers_xid= new BargainsAccounts();
		
		bargainsUsers_xid= bargainsUsersServiceImpl.bargainsUsersXID(id);
				
		return bargainsUsers_xid;
	}
	
	@PutMapping("/chollos-usuario/{id}")
	public BargainsAccounts updatebargainsUsers(@PathVariable(name="id")Long id,@RequestBody BargainsAccounts bargainsUsers) {
		
		BargainsAccounts bargainusersSelected= new BargainsAccounts();
		BargainsAccounts bargainusersUpdated = new BargainsAccounts();
		
		bargainusersSelected = bargainsUsersServiceImpl.bargainsUsersXID(id);
		
		bargainusersSelected.setAccount(bargainsUsers.getAccount());
		bargainusersSelected.setBargain(bargainsUsers.getBargain());

	
		bargainusersUpdated = bargainsUsersServiceImpl.updatebargainsUsers(bargainusersSelected);
				
		return bargainusersUpdated;
	}
	
	@DeleteMapping("/cholloreservado/cambiar-estado/{id}")
	public void changeStatusBook(@PathVariable(name="id")Long id) {
		
		BargainsAccounts bargainsUsers = bargainsUsersXID(id);		
		bargainsUsers.setBooked(0);
	}
	
	@DeleteMapping("/chollofavorito/cambiar-estado/{id}")
	public void changeStatusBookmarked(@PathVariable(name="id")Long id) {
		
		BargainsAccounts bargainsUsers = bargainsUsersXID(id);		
		bargainsUsers.setBookmarked(0);
	}
	
	@DeleteMapping("/chollos-usuario/{id}")
	public void deleteBargainsUsers(@PathVariable(name="id")Long id) {
		bargainsUsersServiceImpl.deleteBargainsUsers(id);
	}	
}
