package com.rev.repo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.repo.bean.UserInfo;
import com.rev.repo.dao.UserInfoDao;

@Service
public class UserInfoService {
	@Autowired
	UserInfoDao dao;
	
	public void setDao(UserInfoDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	public List<UserInfo> getAll() {
		return dao.getUserInfo();
	}
	
	@Transactional
	public UserInfo getOne(String userId) {
		return dao.getUserInfo(userId);
	}
	
	@Transactional
	public void newUserInfo(String userId, String email) {
		dao.newUserInfo(userId, email);
	}
}
