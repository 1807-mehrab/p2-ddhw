package com.rev.repo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERINFO")
public class UserInfo {
	@Id
	@Column(name="USERID")
	private UserProfile  user;
	@Column(name="EMAIL")
	private String email;
	
	@Override
	public String toString() {
		return "UserInfo [userId=" + getUserId() + ", email=" + email + "]";
	}
	
	public UserInfo(UserProfile userId, String email) {
		super();
		this.user = userId;
		this.email = email;
	}

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserProfile getUserId() {
		return user;
	}

	public void setUserId(UserProfile userId) {
		this.user = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
