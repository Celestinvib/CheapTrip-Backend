package com.cheaptrip.demo.service;

import java.util.List;

import com.cheaptrip.demo.dto.Role;

public interface IRoleService {
	
	//CRUD
	public List<Role> listRoles(); 		//List

	public Role saveRole(Role role);	//Save

	public Role roleByID(Long id); 		//Read

	public Role updateRole(Role role);	//Update

	public void deleteRole(Long id);	//Delete
}
