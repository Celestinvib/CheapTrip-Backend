package com.cheaptrip.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cheaptrip.demo.dao.IAccountDAO;
import com.cheaptrip.demo.dto.Account;
import com.cheaptrip.demo.dto.BargainsAccounts;
import com.cheaptrip.demo.dto.Role;
import com.cheaptrip.demo.service.AccountServiceImpl;
import com.cheaptrip.demo.service.BargainsAccountsServiceImpl;

@RestController
public class BargainsAccountsController {
	
	@Autowired
	BargainsAccountsServiceImpl bargainsAccountsServiceImpl;
	
	AccountServiceImpl accountServiceImpl;
	
	private IAccountDAO iUserDAO;


	
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
	
	@GetMapping("/reservas/{id_cuenta}")
	public List<BargainsAccounts> listBargainsAccountsBookedByAccount(@PathVariable(name="id_cuenta") Long accountId) {
		
		List<BargainsAccounts> bargainsAccounts = bargainsAccountsServiceImpl.listBargainsAccounts();
		List<BargainsAccounts> bookings = new ArrayList<>();
		
		for(int i = 0; i < bargainsAccounts.size(); i++) {
			if((bargainsAccounts.get(i).getAccount().getId() == accountId) && (bargainsAccounts.get(i).getBooked() == 1)) {
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
	
	@GetMapping("/chollo-cuenta/{id}")
	public BargainsAccounts bargainsAccountsXID(@PathVariable(name="id") Long id) {
		
		BargainsAccounts bargainsAccounts_xid= new BargainsAccounts();
		
		bargainsAccounts_xid= bargainsAccountsServiceImpl.bargainsAccountsXID(id);
							
		return bargainsAccounts_xid;
	}
	
	@PostMapping("/chollos-favoritos")
	public BargainsAccounts saveBookmarkedBargain(@RequestBody BargainsAccounts bargainsUsers) {
		bargainsUsers.setBookmarked(1);
		return bargainsAccountsServiceImpl.saveBargainsAccounts(bargainsUsers);
	}
	
	@PostMapping("/reservas")
	public BargainsAccounts saveBookedBargain(@RequestBody BargainsAccounts bargainsUsers) {
		bargainsUsers.setBooked(1);
		return bargainsAccountsServiceImpl.saveBargainsAccounts(bargainsUsers);
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
	
	@PutMapping("/chollo-reservado/cambiar-estado/{id}")
	public ResponseEntity changeStatusBooked(@PathVariable(name="id")Long id) {
		
		BargainsAccounts bargainsAccounts = bargainsAccountsXID(id);
		BargainsAccounts bargainsAccountsUpdated = new BargainsAccounts();

		Account accountSelected = bargainsAccounts.getAccount(); 
		
		//If the account is trying to change the status is the same as the one who have the rel allows it
		if (accountSelected == null) {
			
			return new ResponseEntity<Object>("No account found with that id...",HttpStatus.INTERNAL_SERVER_ERROR);
		
		}else {
			
			String accountSelectedEmail = accountSelected.getEmail();
			String loggedAccountEmail = ((Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail();

			Set<Role> accountRoles = ((Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getRoles();

			HashSet<String> userRolesArray = new HashSet<String>(accountRoles.size());

			// Get all the roles 
			for (Role role : accountRoles) {
				userRolesArray.add(role.toString());
			}
 
			//If the account that is trying to delete is the same that is making the request (account logged) or is an admin account allows to change it
			if (accountSelectedEmail.equals(loggedAccountEmail) || userRolesArray.contains("ROLE_ADMIN") == true) {  

				if(bargainsAccounts.getBooked() == 0) { 
					bargainsAccounts.setBooked(1);
				}else {
					bargainsAccounts.setBooked(0);	
				}
				
				bargainsAccountsUpdated = bargainsAccountsServiceImpl.updateBargainsAccounts(bargainsAccounts);
				
					return new ResponseEntity<Object>(bargainsAccountsUpdated, HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>("You have no permission to book/unbook for this account",HttpStatus.UNAUTHORIZED);
			}
		}
		

		

	}
	@PutMapping("/chollo-favorito/cambiar-estado/{id}")
	public ResponseEntity changeStatusBookmarked(@PathVariable(name="id")Long id) {
			
		
		BargainsAccounts bargainsAccounts = bargainsAccountsXID(id);
		BargainsAccounts bargainsAccountsUpdated = new BargainsAccounts();
		
		Account accountSelected = bargainsAccounts.getAccount(); 
		
		//If the account is trying to change the status is the same as the one who have the rel allows it
		if (accountSelected == null) {
			
			return new ResponseEntity<Object>("No account found with that id...",HttpStatus.INTERNAL_SERVER_ERROR);
		
		}else {
			
			String accountSelectedEmail = accountSelected.getEmail();
			String loggedAccountEmail = ((Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail();

			Set<Role> accountRoles = ((Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getRoles();

			HashSet<String> userRolesArray = new HashSet<String>(accountRoles.size());

			// Get all the roles 
			for (Role role : accountRoles) {
				userRolesArray.add(role.toString());
			}
 
			//If the account that is trying to delete is the same that is making the request (account logged) or is an admin account allows to change it
			if (accountSelectedEmail.equals(loggedAccountEmail) || userRolesArray.contains("ROLE_ADMIN") == true) {  

				if(bargainsAccounts.getBookmarked() == 0) { 
					bargainsAccounts.setBookmarked(1);
				}else {
					bargainsAccounts.setBookmarked(0);	
				}
				
				bargainsAccountsUpdated = bargainsAccountsServiceImpl.updateBargainsAccounts(bargainsAccounts);
				
					return new ResponseEntity<Object>(bargainsAccountsUpdated, HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>("You have no permission to bookmark/unbookmark for this account",HttpStatus.UNAUTHORIZED);
			}
		}

	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/chollos-cuentas/{id}")
	public void deleteBargainsAccounts(@PathVariable(name="id")Long id) {
		bargainsAccountsServiceImpl.deleteBargainsAccounts(id);
	}	
}
