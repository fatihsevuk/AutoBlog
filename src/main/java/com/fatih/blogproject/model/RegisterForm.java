package com.fatih.blogproject.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class RegisterForm {
	
	@Size(min=2 , max=30 ,message="Kullanıcı adı 2 ile 30 karakter arası olmalıdır.")
	private String username;
	
	@NotNull
	@Size(min=8 , max=80 ,message="Başlık 8 ile 80 karakter arası olmalıdır.")
	private String title;
	
	@Size(max=120 ,message="Açıklama 120 karakteri geçemez!")
	private String description;
	
	@NotNull
	@Size(min=2 , max=50 , message="Parola 2 ile 50 karakter arası olmalıdır.")
	private String password;
	
	@NotNull
	@Size(min=2 , max=50 , message="Parola 2 ile 50 karakter arası olmalıdır.")
	private String rePassword;
	
	@Email
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
