package com.rev.repo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERPROFILE")
public class UserProfile {

	@Id
	@Column(name="USERID")
	private String userid;
	@Column(name="USERPASS")
	private String userpass;
	@Column(name="ADMIN")
	private int adminInt;
	
	public boolean isAdmin() {
		if (adminInt == 0) return false;
		else return true;
	}

	@Override
	public String toString() {
		return "UserProfile [userid=" + userid + ", userpass=" + userpass + ", admin=" + this.isAdmin() + "]";
	}

	public UserProfile(String userid, String userpass, int adminInt) {
		super();
		this.userid = userid;
		this.userpass = userpass;
		this.adminInt = adminInt;
	}

	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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
	
	
	
}
