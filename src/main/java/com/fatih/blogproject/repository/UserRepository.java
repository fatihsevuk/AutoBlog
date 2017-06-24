package com.fatih.blogproject.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatih.blogproject.entity.User;

@Repository
@Qualifier("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
	User findByEmail(String email);
}
