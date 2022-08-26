package com.cheaptrip.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cheaptrip.demo.dto.Role;
import com.cheaptrip.demo.service.RoleServiceImpl;

@RestController
public class RoleController {

	@Autowired
	RoleServiceImpl roleServiceImpl;
	
	@GetMapping("/roles")
	public List<Role> listRoles(){
		
		return roleServiceImpl.listRoles();
	}
	
	@PostMapping("/roles")
	public Role saveRole(@RequestBody Role role) {
		
		return roleServiceImpl.saveRole(role);
	}
	
	@GetMapping("/roles/{id}")
	public Role roleByID(@PathVariable(name="id") Long id) {
		
		Role role_byid= new Role();
		
		role_byid= roleServiceImpl.roleByID(id);
				
		return role_byid;
	}
	
	@PutMapping("/roles/{id}")
	public Role updateRole(@PathVariable(name="id")Long id,@RequestBody Role role) {
		
		Role roleSelected= new Role();
		Role roleUpdated = new Role();
		
		roleSelected = roleServiceImpl.roleByID(id);
		
		roleSelected.setName(role.getName());
	
		roleUpdated = roleServiceImpl.updateRole(roleSelected);
				
		return roleUpdated;
	}
	
	@DeleteMapping("/roles/{id}")
	public void changeStatusRole(@PathVariable(name="id")Long id) {
		roleServiceImpl.deleteRole(id);
	}	
	
	@DeleteMapping("/roles/{id}")
	public void deleteRole(@PathVariable(name="id")Long id) {
		roleServiceImpl.deleteRole(id);
	}	
}
