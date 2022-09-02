package com.cheaptrip.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheaptrip.demo.dao.IAccountDAO;
import com.cheaptrip.demo.dto.Account;
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
	
	@PostMapping("/cuentas")
	public Account saveUser(@RequestBody Account user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		iUserDAO.save(user);
		return user;
	}

	@GetMapping("/cuentas")
	public List<Account> getAllUser() {
		return iUserDAO.findAll();
	}

	@GetMapping("/cuentas/{email}")
	public Account getUser(@PathVariable String email) {
		return iUserDAO.findByEmail(email);
	}
	
	@PutMapping("/cuentas/{id}")
	public Account updateAccount(@PathVariable(name="id")Long id,@RequestBody Account account) {
		
		Account accountSelected= new Account();
		Account accountUpdated = new Account();
		
		accountSelected = accountServiceImpl.accountByID(id);
		
		accountSelected.setName(account.getName());
	
		accountUpdated = accountServiceImpl.updateAccount(accountSelected);
				
		return accountUpdated;
	}
	
	@DeleteMapping("/cuentas/{id}")
	public String deleteUser(@PathVariable(name="id")long id) {
		iUserDAO.deleteById(id);
		return "User deleted.";
	}
}
