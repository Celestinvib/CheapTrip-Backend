package com.cheaptrip.demo.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService {
	
	public UserDetails loadUserByUsername(String username);
	
}