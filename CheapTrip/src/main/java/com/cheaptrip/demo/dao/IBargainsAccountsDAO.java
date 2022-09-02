package com.cheaptrip.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheaptrip.demo.dto.BargainsAccounts;


public interface IBargainsAccountsDAO extends JpaRepository<BargainsAccounts, Long>{
	
	public List<BargainsAccounts> findBookmarkedByAccount(Long accountId);
}

