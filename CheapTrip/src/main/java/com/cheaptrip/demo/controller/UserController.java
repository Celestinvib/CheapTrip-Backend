package com.cheaptrip.demo.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheaptrip.demo.dao.IUserDAO;
import com.cheaptrip.demo.dto.User;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {

	private IUserDAO iUserDAO;

//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//	public UserController(IUserDAO iUserDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
//		this.iUserDAO = iUserDAO;
//		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//	}
//	
//	
//	@GetMapping("/response-entity-builder-with-http-headers")
//	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
//	    HttpHeaders responseHeaders = new HttpHeaders();
//	    responseHeaders.set("Baeldung-Example-Header", 
//	      "Value-ResponseEntityBuilderWithHttpHeaders");
//
//	    return ResponseEntity.ok()
//	      .headers(responseHeaders)
//	      .body("Response with header using ResponseEntity");
//	}
//	
//	@PostMapping("/users/")
//	public User saveUsuario(@RequestBody User user) {
////		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//		iUserDAO.save(user);
//		return user;
//	}
//
//	@GetMapping("/users/")
//	public List<User> getAllUsuarios() {
//		return iUserDAO.findAll();
//	}
//
//	@GetMapping("/users/{username}")
//	public User getUsuario(@PathVariable String name) {
//		return iUserDAO.findByName(name);
//	}
//	
//	@DeleteMapping("/users/{id}")
//	public String eliminarUser(@PathVariable(name="id")long id) {
//		iUserDAO.deleteById(id);
//		return "User deleted.";
//	}
}
