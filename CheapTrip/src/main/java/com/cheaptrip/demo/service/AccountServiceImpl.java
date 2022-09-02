package com.cheaptrip.demo.service;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cheaptrip.demo.dao.IAccountDAO;
import com.cheaptrip.demo.dto.Account;

@Service
public class AccountServiceImpl implements UserDetailsService {

	private IAccountDAO iUserDAO;

	public AccountServiceImpl(IAccountDAO iUserDAO) {
		this.iUserDAO = iUserDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Account user = iUserDAO.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(email);
		}
		return new User(user.getEmail(), user.getPassword(), emptyList());
	}
	
}