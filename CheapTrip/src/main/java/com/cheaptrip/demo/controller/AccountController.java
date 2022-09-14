package com.cheaptrip.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheaptrip.demo.dao.IAccountDAO;
import com.cheaptrip.demo.dto.Account;
import com.cheaptrip.demo.dto.Bargain;
import com.cheaptrip.demo.dto.Role;
import com.cheaptrip.demo.service.AccountServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AccountController {

	@Autowired
	AccountServiceImpl accountServiceImpl;
	
	private IAccountDAO iUserDAO;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public AccountController(IAccountDAO iUserDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.iUserDAO = iUserDAO;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Baeldung-Example-Header", 
	      "Value-ResponseEntityBuilderWithHttpHeaders");

	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body("Response with header using ResponseEntity");
	}
	
	@PostMapping("/registrar")
	public Account saveAccount(@RequestBody Account account) {
		account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
		
		/*
		 * Set the role of the account to normal user so that even though they bypass the frontend security 
		 * the admins accounts cannot be created using the public registry)
		 */		
		Role role = new Role(11);
	
		role.setName("ROLE_USER");
		account.addRole(role);
		account.setStatus(1); //Sets the account status to 1 (active account)
			
		//Sets the creation date the current date
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new Date(date.getTime());
		account.setCreation_date(sqlDate);
		
		iUserDAO.save(account);
		return account;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public ResponseEntity<String> test()
    {
        return ResponseEntity.ok()
                  .body("Admin role works perfectly!");
    }

	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/cuentas/admin")
	public Account saveAccountAdmin(@RequestBody Account account) {
		account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
		
		Role role = new Role(1);
		
		role.setName("ROLE_ADMIN");
		account.addRole(role);
		account.setStatus(1); //Sets the account status to 1 (active account)
		
		//Sets the creation date the current date
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new Date(date.getTime());
		account.setCreation_date(sqlDate);
		
		iUserDAO.save(account);
		return account;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/cuentas")
	public List<Account> getAllAccounts() {
		return iUserDAO.findAll();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/cuentas/{email}")
	public Account getAccount(@PathVariable String email) {
		return iUserDAO.findByEmail(email);
	}
	
	@GetMapping("/cuenta/{id}")
	public Account accountXID(@PathVariable(name="id") Long id) {
		
		Account accountXID= new Account();
		
		accountXID= accountServiceImpl.accountByID(id);
				
		return accountXID;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/cuentas/{id}")
	public Account updateAccount(@PathVariable(name="id")Long id,@RequestBody Account account) {
		
		Account accountSelected= new Account();
		Account accountUpdated = new Account();
		
		accountSelected = accountServiceImpl.accountByID(id);
		
		accountSelected.setName(account.getName());
		accountSelected.setSurnames(account.getSurnames());
		accountSelected.setEmail(account.getEmail());
		accountSelected.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
		accountSelected.setPhone_number(account.getPhone_number());
	
		accountUpdated = accountServiceImpl.updateAccount(accountSelected);
				
		return accountUpdated;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/cuentas/cambiar-estado/{id}")
    public Account changeStatusAccount(@PathVariable(name="id")Long id) {

		Account account = accountServiceImpl.accountByID(id);
		Account accountUpdated = new Account();

        if(account.getStatus() == 0) { 
            account.setStatus(1);
        }else {
            account.setStatus(0);
        }

        accountUpdated = accountServiceImpl.updateAccount(account);
        return accountUpdated;
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/cuentas/{id}")
	public String deleteAccount(@PathVariable(name="id")long id) {
		iUserDAO.deleteById(id);
		return "Account deleted.";
	}
}
