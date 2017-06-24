package com.fatih.blogproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fatih.blogproject.entity.Post;
import com.fatih.blogproject.entity.User;
import com.fatih.blogproject.repository.PostRepository;
import com.fatih.blogproject.service.PostService;

@Service
@Primary
public class PostServiceJPAImpl implements PostService{
	
	private PostRepository postRepository;
	
	@Autowired
	public PostServiceJPAImpl(PostRepository postRepository) {
		this.postRepository=postRepository;
	}
	

	@Override
	public List<Post> findAll() {
		
		return postRepository.findAll();
	}

	@Override
	public List<Post> findLatest5() {
		
		return postRepository.findLatest5Posts(new PageRequest(0,5));
	}

	@Override
	public Post findById(Long id) {
		
		return postRepository.findOne(id);
	}

	@Override
	public Post create(Post post) {
		
		return postRepository.save(post);
	}

	@Override
	public Post edit(Post post) {
		
		return postRepository.save(post);
	}

	@Override
	public void deleteById(Long id) {
		postRepository.delete(id);
		
	}


	@Override
	public List<Post> findByAuthor(User author) {
		// TODO Auto-generated method stub
		return postRepository.findByAuthorOrderByDateDesc(author);
	}


	@Override
	public List<Post> findTop5ByAuthor(User author) {
		// TODO Auto-generated method stub
		return postRepository.findTop5ByAuthorOrderByDateDesc(new PageRequest(0,5), author);
	}


	@Override
	public List<Post> findByDraft(boolean draft) {
		// TODO Auto-generated method stub
		return postRepository.findByDraft(draft);
	}

}
