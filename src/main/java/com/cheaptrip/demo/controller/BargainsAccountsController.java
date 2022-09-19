package com.cheaptrip.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cheaptrip.demo.dto.BargainsAccounts;
import com.cheaptrip.demo.service.BargainsAccountsServiceImpl;

@RestController
public class BargainsAccountsController {
	
	@Autowired
	BargainsAccountsServiceImpl bargainsAccountsServiceImpl;
	
	
	@GetMapping("/reservas")
	public List<BargainsAccounts> listBargainsAccountsBooked() {
		
		List<BargainsAccounts> bargainsAccounts = bargainsAccountsServiceImpl.listBargainsAccounts();
		List<BargainsAccounts> bookings = new ArrayList<>();
		
		for(int i = 0; i < bargainsAccounts.size(); i++) {
			if(bargainsAccounts.get(i).getBooked() == 1) {
				bookings.add(bargainsAccounts.get(i));
			}
		}
		
		return bookings;
	}
	
	@GetMapping("/chollos-favoritos/{id_cuenta}")
	public List<BargainsAccounts> findBookmarkedByAccount(@PathVariable(name="id_cuenta") Long accountId){
		
		List<BargainsAccounts> bargainsAccounts = bargainsAccountsServiceImpl.listBargainsAccounts();
		List<BargainsAccounts> bargainsAccountsSelected = new ArrayList<>();
		
		for(int i = 0; i < bargainsAccounts.size(); i++) {
			if((bargainsAccounts.get(i).getAccount().getId() == accountId) && (bargainsAccounts.get(i).getBookmarked() == 1)) {
				bargainsAccountsSelected.add(bargainsAccounts.get(i));
			}
		}
		
		return bargainsAccountsSelected;
	}
	
	
	@GetMapping("/reservas/{id}")
	public BargainsAccounts bargainsAccountsXID(@PathVariable(name="id") Long id) {
		
		BargainsAccounts bargainsAccounts_xid= new BargainsAccounts();
		
		bargainsAccounts_xid= bargainsAccountsServiceImpl.bargainsAccountsXID(id);
				
		return bargainsAccounts_xid;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/chollos-cuentas/{id}")
	public BargainsAccounts updateBargainsAccounts(@PathVariable(name="id")Long id,@RequestBody BargainsAccounts bargainsUsers) {
		
		BargainsAccounts bargainAccountsSelected= new BargainsAccounts();
		BargainsAccounts bargainAccountsUpdated = new BargainsAccounts();
		
		bargainAccountsSelected = bargainsAccountsServiceImpl.bargainsAccountsXID(id);
		
		bargainAccountsSelected.setAccount(bargainsUsers.getAccount());
		bargainAccountsSelected.setBargain(bargainsUsers.getBargain());

	
		bargainAccountsUpdated = bargainsAccountsServiceImpl.updateBargainsAccounts(bargainAccountsSelected);
				
		return bargainAccountsUpdated;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/chollo-reservado/cambiar-estado/{id}")
	public BargainsAccounts changeStatusBooked(@PathVariable(name="id")Long id) {
		
		BargainsAccounts bargainsAccounts = bargainsAccountsXID(id);
		BargainsAccounts bargainsAccountsUpdated = new BargainsAccounts();

		
		if(bargainsAccounts.getBooked() == 0) { 
			bargainsAccounts.setBooked(1);
		}else {
			bargainsAccounts.setBooked(0);	
		}
		
		bargainsAccountsUpdated = bargainsAccountsServiceImpl.updateBargainsAccounts(bargainsAccounts);
		return bargainsAccountsUpdated;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/chollo-favorito/cambiar-estado/{id}")
	public BargainsAccounts changeStatusBookmarked(@PathVariable(name="id")Long id) {
		
		BargainsAccounts bargainsAccounts = bargainsAccountsXID(id);
		BargainsAccounts bargainsAccountsUpdated = new BargainsAccounts();

		
		if(bargainsAccounts.getBookmarked() == 0) { 
			bargainsAccounts.setBookmarked(1);
		}else {
			bargainsAccounts.setBookmarked(0);	
		}
		
		bargainsAccountsUpdated = bargainsAccountsServiceImpl.updateBargainsAccounts(bargainsAccounts);
		return bargainsAccountsUpdated;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/chollos-cuentas/{id}")
	public void deleteBargainsAccounts(@PathVariable(name="id")Long id) {
		bargainsAccountsServiceImpl.deleteBargainsAccounts(id);
	}	
}
