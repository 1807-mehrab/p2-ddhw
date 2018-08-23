package com.rev.repo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.repo.bean.UserProfile;
import com.rev.repo.dao.UserProfileDao;

@Service
public class UserProfileService {
	@Autowired
	UserProfileDao dao;
	
	public void setDao(UserProfileDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	public List<UserProfile> getAll() {
		return dao.getUserProfile();
	}
	
	@Transactional
	public UserProfile getOne(UserProfile user_get) {
		return dao.getUserProfile(user_get.getUser());
	}
	
	@Transactional
	public UserProfile newUserProfile(UserProfile up) {
		return dao.newUserProfile(up);
	}

	@Transactional
	public UserProfile authentication(UserProfile user_get) {
		return dao.authenticate(user_get.getUser(), user_get.getUserpass());
	}
	
	
	
//	admin delete users--
	@Transactional
	public Boolean deleteUser(UserProfile user) {
		return dao.adminDeleteUser(user.getUser());
	}
	
//	promote users to admin--
	@Transactional
	public void adminGrantAdmin(UserProfile user) {
		dao.editAdmin(user.getUser());
	}

}
