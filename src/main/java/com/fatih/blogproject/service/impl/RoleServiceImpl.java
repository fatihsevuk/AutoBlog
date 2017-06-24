package com.fatih.blogproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatih.blogproject.entity.Role;
import com.fatih.blogproject.repository.RoleRepository;
import com.fatih.blogproject.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	
	
	private RoleRepository roleRepository;
	
	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		
		this.roleRepository=roleRepository;
	}
	
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public Role findByName(String name) {
		// TODO Auto-generated method stub
		return roleRepository.findByName(name);
	}

	@Override
	public Role findById(long id) {
		// TODO Auto-generated method stub
		return roleRepository.findOne(id);
	}

}
