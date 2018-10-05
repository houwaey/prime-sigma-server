package com.sigma.builder;

import java.util.Date;

import com.sigma.model.WebUser;

public class WebUserBuilder {

	private String username;
	private String password;
	private String email;
	private String status;
	private Date dateCreated;
	
	public WebUserBuilder username(String username) {
		this.username = username;
		return this;
	}
	
	public WebUserBuilder password(String password) {
		this.password = password;
		return this;
	}
	
	public WebUserBuilder email(String email) {
		this.email = email;
		return this;
	}
	
	public WebUserBuilder status(String status) {
		this.status = status;
		return this;
	}
	
	public WebUserBuilder dateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
		return this;
	}
	
	public WebUser build() {
		WebUser user = new WebUser();
		user.setUsername(this.username);
		user.setPassword(this.password);
		user.setEmail(this.email);
		user.setStatus(this.status);
		user.setDateCreated(this.dateCreated);
		return user;
	}

	
}
