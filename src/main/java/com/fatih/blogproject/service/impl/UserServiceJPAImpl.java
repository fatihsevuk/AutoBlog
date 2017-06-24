package com.fatih.blogproject.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.fatih.blogproject.entity.User;
import com.fatih.blogproject.repository.UserRepository;
import com.fatih.blogproject.service.UserService;
import com.fatih.blogproject.utility.Hashing;

@Service
@Primary
public class UserServiceJPAImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceJPAImpl(UserRepository userRepository) {
		this.userRepository = userRepository;

	}

	@Override
	public boolean loginAuthenticate(String username, String password) {

		User user = userRepository.findByUsername(username);
		

		if (user != null) {

			if (Hashing.checkPassword(password,user.getPasswordHash())) {

				System.out.println("user is logged");

				return true;
			} else {

				System.out.println("Icorrect password");

				return false;
			}

		} else {

			System.out.println("this user name already exists");
			return false;

		}

	}

	@Override
	public boolean registerAuthenticate(String username, String email) {

		User user1 = userRepository.findByUsername(username);
		User user2=userRepository.findByEmail(email);
		
		
		
		if (user1 == null && user2==null){

				System.out.println("registered");
				return true;
				
		} else {

				System.out.println("usernme or email already exists");

				return false;
		}

		
	}

	@Override
	public List<User> findAll() {

		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {

		return userRepository.findOne(id);
	}

	@Override
	public User create(User user) {
		

		return userRepository.save(user);
	}

	@Override
	public User edit(User user) {

		return userRepository.save(user);
	}

	@Override
	public void deleteById(Long id) {
		userRepository.delete(id);

	}

	@Override
	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

}
