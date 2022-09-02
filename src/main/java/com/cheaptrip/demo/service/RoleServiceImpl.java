package com.cheaptrip.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheaptrip.demo.dao.IRoleDAO;
import com.cheaptrip.demo.dto.Role;

@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	IRoleDAO iRoleDAO;
	
	@Override
	public List<Role> listRoles() {
		return iRoleDAO.findAll();
	}

	@Override
	public Role saveRole(Role role) {
		return iRoleDAO.save(role);
	}

	@Override
	public Role roleByID(Long id) {
		return iRoleDAO.findById(id).get();
	}

	@Override
	public Role updateRole(Role role) {
		return iRoleDAO.save(role);
	}

	@Override
	public void deleteRole(Long id) {
		iRoleDAO.deleteById(id);		
	}

}
