package com.cheaptrip.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBargainDAO extends JpaRepository<Object, Long>{
	/**
	 * CHANGE OBJECT TO BARGAIN
	 */
}