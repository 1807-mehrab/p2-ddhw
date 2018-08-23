package com.rev.repo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rev.repo.bean.Reply;
import com.rev.repo.bean.UserInfo;
import com.rev.repo.bean.UserProfile;

@Transactional
@Repository
public class UserInfoDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInfo> getAllUserInfo() {
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from UserInfo").list();
	}
	
	@SuppressWarnings("unchecked")
	public UserInfo getUserInfo(String userId) {
		Session s = sessionFactory.getCurrentSession();
		UserInfo ui = null;
		List<UserInfo> users = s.createQuery("from UserInfo where USERID = :id").setString("id", userId).list();
		
		if (!users.isEmpty()) {
			ui = users.get(0);
		}
		
		return ui;
	}
	
	public UserInfo newUserInfo(UserInfo ui) {
		Session s = sessionFactory.getCurrentSession();
		s.save(ui);
		return ui;
	}

	public void editUserInfo(String string, String email) {
		Session s = sessionFactory.getCurrentSession();
		UserInfo instance = s.load(UserInfo.class, string);
		instance.setEmail(email);
		s.saveOrUpdate(instance);
	}
}
