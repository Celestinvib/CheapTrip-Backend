package com.cheaptrip.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheaptrip.demo.dto.Role;

public interface IRoleDAO extends JpaRepository<Role, Long>{
	
}