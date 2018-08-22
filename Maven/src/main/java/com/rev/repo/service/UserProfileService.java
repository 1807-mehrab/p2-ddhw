package com.rev.repo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.repo.bean.UserInfo;
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
	public UserProfile getOne(String userId) {
		return dao.getUserProfile(userId);
	}
	
	@Transactional
	public void newUserProfile(UserInfo user, String email, int adminInt) {
		dao.newUserProfile(user, email, adminInt);
	}
}
