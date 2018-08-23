package com.rev.repo.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERPROFILE")
public class UserProfile {

	@Id
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "USERID")
	private String user;

	@Column(name = "USERPASS")
	private String userpass;

	@Column(name = "ADMIN")
	private int adminInt;

	public boolean isAdmin() {
		if (adminInt == 0)
			return false;
		else
			return true;
	}

	@Override
	public String toString() {
		return "UserProfile [user=" + user + ", userpass=" + userpass + ", adminInt=" + adminInt + "]";
	}

	public UserProfile(UserLogin ul) {
		super();
		this.user = ul.getUser();
		this.userpass = ul.getUserpass();
		this.adminInt = ul.getAdminInt();
	}

	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUser() {
		return user;
	}

	public void setUserId(String user) {
		this.user = user;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserPass(String userpass) {
		this.userpass = userpass;
	}

	public int getAdminInt() {
		return adminInt;
	}

	public void setAdminInt(int adminInt) {
		this.adminInt = adminInt;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
