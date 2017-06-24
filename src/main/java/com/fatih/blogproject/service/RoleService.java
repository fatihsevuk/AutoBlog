package com.fatih.blogproject.service;

import java.util.List;

import com.fatih.blogproject.entity.Role;

public interface RoleService {
	List<Role> findAll();
	Role findByName(String name);
	Role findById(long id);

}
