package com.cheaptrip.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheaptrip.demo.dto.BargainsAccounts;


public interface IBargainsAccountsDAO extends JpaRepository<BargainsAccounts, Long>{
	
	
}

