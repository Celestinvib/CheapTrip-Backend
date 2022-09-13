package com.cheaptrip.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheaptrip.demo.dto.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
	 
}