package com.springjpa.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cni.security.BCrypt;
import com.springjpa.model.Role;
import com.springjpa.repo.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository RR;

	public List<Role> findallroles() {
		List<Role> List= RR.findallRoles();
		System.out.print(List);
		return List;
	}
	

}
