package com.cheaptrip.demo.controller;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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
import org.springframework.http.MediaType;


import com.cheaptrip.demo.dao.IAccountDAO;
import com.cheaptrip.demo.dto.Account;
import com.cheaptrip.demo.dto.Bargain;
import com.cheaptrip.demo.dto.Role;
import com.cheaptrip.demo.service.AccountServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AccountController {

	@Autowired
	AccountServiceImpl accountServiceImpl;
	
	private IAccountDAO iUserDAO;

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private Gson gson = new Gson();

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
	
	@GetMapping(value = "/obtener-rol", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAccountRoles() {		

		//Create an empty json object
		JsonObject json = new JsonObject();

		// Add The authentication (role of the account that is sending the req ) to it removing the brackets in the process
		json.addProperty("roles", SecurityContextHolder
				.getContext().getAuthentication().getAuthorities().toString()
				.replace("[", "")
			    .replace("]", ""));
		
		//Returns the json object
		String accountrRole = this.gson.toJson(json);
		
		return ResponseEntity.ok().body(accountrRole);
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
	public ResponseEntity accountXID(@PathVariable(name="id") Long id) {
		
		Account accountXID= new Account();
		
		accountXID= accountServiceImpl.accountByID(id);
		
		if (accountXID == null) {
			
			return new ResponseEntity<Object>("No account found with that id...",HttpStatus.INTERNAL_SERVER_ERROR);
		
		}else {
			
			String accountSelectedEmail = accountServiceImpl.accountByID(id).getEmail();
			String loggedAccountEmail = ((Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail();

			Set<Role> accountRoles = ((Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getRoles();

			HashSet<String> userRolesArray = new HashSet<String>(accountRoles.size());

			// Get all the roles 
			for (Role role : accountRoles) {
				userRolesArray.add(role.toString());
			}
 
			//If the account that is trying to update is the same that is making the request (account logged) or is an admin account allows to update it
			if (accountSelectedEmail.equals(loggedAccountEmail) || userRolesArray.contains("ROLE_ADMIN") == true) {  
				
					return new ResponseEntity<Object>(accountXID, HttpStatus.OK);
					
			}else {
				return new ResponseEntity<Object>("You have no permission to edit this account",HttpStatus.UNAUTHORIZED);
			}
		}			
	}
	
	@PutMapping("/cuentas/{id}")
	public ResponseEntity updateAccount(@PathVariable(name="id")Long id,@RequestBody Account account) {
		
		Account accountSelected = accountServiceImpl.accountByID(id);

		if (accountSelected == null) {
			
			return new ResponseEntity<Object>("No account found with that id...",HttpStatus.INTERNAL_SERVER_ERROR);
		
		}else {
			
			String accountSelectedEmail = accountServiceImpl.accountByID(id).getEmail();
			String loggedAccountEmail = ((Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail();

			Set<Role> accountRoles = ((Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getRoles();

			HashSet<String> userRolesArray = new HashSet<String>(accountRoles.size());

			// Get all the roles 
			for (Role role : accountRoles) {
				userRolesArray.add(role.toString());
			}
 
			//If the account that is trying to update is the same that is making the request (account logged) or is an admin account allows to update it
			if (accountSelectedEmail.equals(loggedAccountEmail) || userRolesArray.contains("ROLE_ADMIN") == true) {  
				accountSelected.setName(account.getName());
				accountSelected.setSurnames(account.getSurnames());
				accountSelected.setEmail(account.getEmail());
				accountSelected.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
				accountSelected.setPhone_number(account.getPhone_number());
				
				 accountServiceImpl.updateAccount(accountSelected);
				
					return new ResponseEntity<Object>(accountSelected, HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>("You have no permission to edit this account",HttpStatus.UNAUTHORIZED);
			}
		}
							
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
