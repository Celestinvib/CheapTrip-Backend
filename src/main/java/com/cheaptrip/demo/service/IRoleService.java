package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.Role;

public interface IRoleService {
	
	//CRUD
	public List<Role> listRoles(); 		

	public Role saveRole(Role role);	

	public Role roleByID(Long id); 		

	public Role updateRole(Role role);	

	public void deleteRole(Long id);	
}
