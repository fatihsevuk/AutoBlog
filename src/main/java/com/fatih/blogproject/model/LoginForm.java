package com.fatih.blogproject.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {
	
	@Size(min=2 , max=30 ,message="Kullanıcı adı en az 2 en fazla 30 karakter olmalıdır.")
	private String username;
	
	@NotNull
	@Size(min=2 , max=50 , message="Parola 2 ile 50 karakter arası olmalıdır.")
	private String password;

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
	
	
	
	

}
