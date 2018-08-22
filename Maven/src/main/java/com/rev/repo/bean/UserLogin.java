package com.rev.repo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "login")
public class UserLogin {

	private String user;
	private String userpass;

	@JsonIgnore
	private int adminInt = -1;

	public String getUser() {
		return user;
	}

	public void setUserid(String user) {
		this.user = user;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public int getAdminInt() {
		return adminInt;
	}

	public void setAdminInt(int adminInt) {
		this.adminInt = adminInt;
	}

	@Override
	public String toString() {
		return "UserLogin [user=" + user + ", userpass=" + userpass + ", adminInt=" + adminInt + "]";
	}

}
