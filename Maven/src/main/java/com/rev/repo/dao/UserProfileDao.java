package com.rev.repo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rev.repo.bean.UserInfo;
import com.rev.repo.bean.UserProfile;

@Transactional
@Repository
public class UserProfileDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserProfile> getUserProfile() {
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from UserProfile").list();
	}
	
	@SuppressWarnings("unchecked")
	public UserProfile getUserProfile(String userId) {
		Session s = sessionFactory.getCurrentSession();
		UserProfile ui = null;
		List<UserProfile> users = s.createQuery("from UserProfile where USERID = :id").setString("id", userId).list();
		
		if (!users.isEmpty()) {
			ui = users.get(0);
		}
		
		return ui;
	}
	
	public void newUserProfile(UserInfo user, String email, int adminInt) {
		Session s = sessionFactory.getCurrentSession();
		s.save(new UserProfile(user, email, adminInt));
	}
}
