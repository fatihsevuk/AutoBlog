package com.fatih.blogproject.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreatePostForm {
	

	
	
	@Size(min=2 ,max=300 ,message="Çok uzun olmayan bir başlık yaz lütfen.")
	@NotNull
	private String title;
	
	
	private String body;
	
	@Size(max=30 ,message="Kategori en fazla 30 karakter olmalı.")
	private String category;
	
	private boolean draft;

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
	
	
	
	
	
	
}
