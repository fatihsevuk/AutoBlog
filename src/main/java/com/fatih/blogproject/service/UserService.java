package com.fatih.blogproject.service;

import java.util.List;

import com.fatih.blogproject.entity.User;

public interface UserService {
	boolean loginAuthenticate(String username , String password);
	boolean registerAuthenticate(String username , String email);
	List<User> findAll();
	User findById(Long id);
	User findByUsername(String username);
	User findByEmail(String email);
	User create(User user);
	User edit(User user);
	void deleteById(Long id);

}
