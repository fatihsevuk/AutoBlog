package com.fatih.blogproject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fatih.blogproject.entity.Post;
import com.fatih.blogproject.entity.User;

@Repository
@Qualifier("postRepository")
public interface PostRepository extends JpaRepository<Post, Long> {
	
	@Query("SELECT p FROM Post p LEFT JOIN FETCH p.author ORDER BY p.date desc")
	List<Post> findLatest5Posts(Pageable pageable );
	
	List<Post> findTop5ByAuthorOrderByDateDesc(Pageable pageable , User author); 
	
	List<Post> findByAuthorOrderByDateDesc(User author);
	
	List<Post> findByDraft(boolean draft);
	
}
