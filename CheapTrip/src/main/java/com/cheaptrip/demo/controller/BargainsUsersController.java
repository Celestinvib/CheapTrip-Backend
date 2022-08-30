package com.cheaptrip.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cheaptrip.demo.dto.BargainsUsers;
import com.cheaptrip.demo.service.BargainsUsersServiceImpl;

public class BargainsUsersController {
	
	@Autowired
	BargainsUsersServiceImpl bargainsUsersServiceImpl;
	
	@GetMapping("/chollosfavoritos")
	public List<BargainsUsers> listBargainsUsersbookmarked() {
		
		return bargainsUsersServiceImpl.listBargainsUsersbookmarked();
	}
	
	@GetMapping("/chollosreservados")
	public List<BargainsUsers> listBargainsUsersbook() {
		
		return bargainsUsersServiceImpl.listBargainsUsersbook();
	}
	
	@GetMapping("/chollos-usuario/{id}")
	public BargainsUsers bargainsUsersXID(@PathVariable(name="id") Long id) {
		
		BargainsUsers bargainsUsers_xid= new BargainsUsers();
		
		bargainsUsers_xid= bargainsUsersServiceImpl.bargainsUsersXID(id);
				
		return bargainsUsers_xid;
	}
	
	@PutMapping("/chollos-usuario/{id}")
	public BargainsUsers updatebargainsUsers(@PathVariable(name="id")Long id,@RequestBody BargainsUsers bargainsUsers) {
		
		BargainsUsers bargainusersSelected= new BargainsUsers();
		BargainsUsers bargainusersUpdated = new BargainsUsers();
		
		bargainusersSelected = bargainsUsersServiceImpl.bargainsUsersXID(id);
		
		bargainusersSelected.setUser(bargainsUsers.getUser());
		bargainusersSelected.setBargain(bargainsUsers.getBargain());

	
		bargainusersUpdated = bargainsUsersServiceImpl.updatebargainsUsers(bargainusersSelected);
				
		return bargainusersUpdated;
	}
	
	@DeleteMapping("/cholloreservado/cambiar-estado/{id}")
	public void changeStatusBook(@PathVariable(name="id")Long id) {
		
		BargainsUsers bargainsUsers = bargainsUsersXID(id);		
		bargainsUsers.setBooked(0);
	}
	
	@DeleteMapping("/chollofavorito/cambiar-estado/{id}")
	public void changeStatusBookmarked(@PathVariable(name="id")Long id) {
		
		BargainsUsers bargainsUsers = bargainsUsersXID(id);		
		bargainsUsers.setBookmarked(0);
	}
	
	@DeleteMapping("/chollos-usuario/{id}")
	public void deleteBargainsUsers(@PathVariable(name="id")Long id) {
		bargainsUsersServiceImpl.deleteBargainsUsers(id);
	}	
}
