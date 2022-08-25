package com.cheaptrip.demo.service;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cheaptrip.demo.dao.IUserDAO;

@Service
public class UserServiceImpl implements IUserService {

	private IUserDAO iUserDAO;

	public UserServiceImpl(IUserDAO iUserDAO) {
		this.iUserDAO = iUserDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.cheaptrip.demo.dto.User user = iUserDAO.findByName(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(user.getUsername(), user.getPassword(), emptyList());
	}
	
}
