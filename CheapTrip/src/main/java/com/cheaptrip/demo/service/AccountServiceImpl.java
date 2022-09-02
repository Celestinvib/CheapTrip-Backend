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

	private IAccountDAO iAccountDAO;

	public AccountServiceImpl(IAccountDAO iAccountDAO) {
		this.iAccountDAO = iAccountDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Account user = iAccountDAO.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(email);
		}
		return new User(user.getEmail(), user.getPassword(), emptyList());
	}

	public Account accountByID(Long id) {
		return iAccountDAO.findById(id).get();
	}

	public Account updateAccount(Account account) {
		return iAccountDAO.save(account);
	}
	
}