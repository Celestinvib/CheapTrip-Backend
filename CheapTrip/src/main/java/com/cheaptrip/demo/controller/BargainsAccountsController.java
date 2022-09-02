package com.cheaptrip.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/reservas")
	public List<BargainsAccounts> listBargainsAccountsBooked() {
		
		return bargainsAccountsServiceImpl.listBargainsAccountsBooked();
	}
	
	@GetMapping("/reservas/{id}")
	public BargainsAccounts bargainsAccountsXID(@PathVariable(name="id") Long id) {
		
		BargainsAccounts bargainsAccounts_xid= new BargainsAccounts();
		
		bargainsAccounts_xid= bargainsAccountsServiceImpl.bargainsAccountsXID(id);
				
		return bargainsAccounts_xid;
	}
	
	@PutMapping("/chollos-usuario/{id}")
	public BargainsAccounts updateBargainsAccounts(@PathVariable(name="id")Long id,@RequestBody BargainsAccounts bargainsUsers) {
		
		BargainsAccounts bargainAccountsSelected= new BargainsAccounts();
		BargainsAccounts bargainAccountsUpdated = new BargainsAccounts();
		
		bargainAccountsSelected = bargainsAccountsServiceImpl.bargainsAccountsXID(id);
		
		bargainAccountsSelected.setAccount(bargainsUsers.getAccount());
		bargainAccountsSelected.setBargain(bargainsUsers.getBargain());

	
		bargainAccountsUpdated = bargainsAccountsServiceImpl.updateBargainsAccounts(bargainAccountsSelected);
				
		return bargainAccountsUpdated;
	}
	
	@DeleteMapping("/chollo-reservado/cambiar-estado/{id}")
	public void changeStatusBooked(@PathVariable(name="id")Long id) {
		
		BargainsAccounts bargainsAccounts = bargainsAccountsXID(id);		
		bargainsAccounts.setBooked(0);
	}
	
	@DeleteMapping("/chollo-favorito/cambiar-estado/{id}")
	public void changeStatusBookmarked(@PathVariable(name="id")Long id) {
		
		BargainsAccounts bargainsAccounts = bargainsAccountsXID(id);		
		bargainsAccounts.setBookmarked(0);
	}
	
	@DeleteMapping("/chollos-usuario/{id}")
	public void deleteBargainsAccounts(@PathVariable(name="id")Long id) {
		bargainsAccountsServiceImpl.deleteBargainsAccounts(id);
	}	
}
