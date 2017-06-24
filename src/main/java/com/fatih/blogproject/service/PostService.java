package com.fatih.blogproject.service;

import java.util.List;

import com.fatih.blogproject.entity.Post;
import com.fatih.blogproject.entity.User;

public interface PostService {
	
	List<Post> findAll();
	List<Post> findByAuthor(User author);
	List<Post> findByDraft(boolean draft);
	List<Post> findLatest5();
	Post findById(Long id);
	List<Post> findTop5ByAuthor(User author);
	Post create(Post post);
	Post edit(Post post);
	void deleteById(Long id);
	
	
	
	
	
}
