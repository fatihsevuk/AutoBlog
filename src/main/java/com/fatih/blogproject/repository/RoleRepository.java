package com.fatih.blogproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatih.blogproject.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{
	public Role findByName(String name);
}
