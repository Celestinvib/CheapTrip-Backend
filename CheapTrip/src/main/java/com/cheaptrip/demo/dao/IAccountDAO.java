package com.cheaptrip.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheaptrip.demo.dto.Account;


public interface IAccountDAO extends JpaRepository<Account, Long>{

	Account findByName(String username);
		
}

