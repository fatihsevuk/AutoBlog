package com.fatih.blogproject.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false , unique=true)
	private long id;
	
	@Column(nullable = false, length = 30, unique = true)
	private String username;
	
	@Column(nullable = false, length = 80)
	private String title;
	
	@Column(length = 120)
	private String description;
	
	@Column(nullable=false , unique=true)
	private String email;
	
	@Column(length = 60)
	private String passwordHash;
	
	@Column(length = 100)
	private String fullName;
	
	@OneToMany(mappedBy = "author" , fetch=FetchType.LAZY)
	private Set<Post> posts=new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles=new HashSet<Role>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Set<Post> getPosts() {
		return posts;
	}
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
		
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(long id, String username, String email, String fullName ,String title ,String description) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.fullName = fullName;
		this.title=title;
		this.description=description;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", title=" + title + ", email=" + email + ", passwordHash="
				+ passwordHash + ", fullName=" + fullName + ", posts=" + posts + "]";
	}
	
	
	
	
	
	
	
	

}
