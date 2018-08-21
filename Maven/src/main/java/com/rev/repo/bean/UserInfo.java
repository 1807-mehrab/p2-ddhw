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
	private String userId;
	@Column(name="EMAIL")
	private String email;
	
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", email=" + email + "]";
	}
	
	public UserInfo(String userId, String email) {
		super();
		this.userId = userId;
		this.email = email;
	}

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
