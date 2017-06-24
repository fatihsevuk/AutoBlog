package com.fatih.blogproject.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(nullable = false, length = 300)
	private String title;
	
	@Lob @Column(nullable = false)
	private String body;
	
	@Column(length=20)
	private String category;
	
	@Column(nullable=false)
	boolean draft;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private User author;
	
	@Column(nullable = false)
	private Date date = new Date();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	public boolean isDraft() {
		return draft;
	}
	public void setDraft(boolean draft) {
		this.draft = draft;
	}
	
	
	
	
	public Post() {
		// TODO Auto-generated constructor stub
	}
	public Post(Long id, String title, String body, User author , String category ,boolean draft) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.author = author;
		this.category=category;
		this.draft=draft;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + ", category=" + category + ", draft=" + draft
				+ ", author=" + author + ", date=" + date + "]";
	}
	
	
	
	
	
	
	
	
	

}
