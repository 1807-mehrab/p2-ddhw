package com.rev.repo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

	public UserProfile newUserProfile(UserProfile up) {
		Session s = sessionFactory.getCurrentSession();
		s.save(up);
		return up;
	}

	public UserProfile authenticate(String userId, String userpass) {
		Session s = sessionFactory.getCurrentSession();
		UserProfile ui = null;
		List<UserProfile> users = s.createQuery("from UserProfile where USERID = :id and USERPASS = :pass")
				.setString("id", userId).setString("pass", userpass).list();
		if (!users.isEmpty()) {
			ui = users.get(0);
		}

		return ui;
	}

	public boolean adminDeleteUser(String user) {
		Session s = sessionFactory.getCurrentSession();
		Object persistentInstance = s.load(UserProfile.class, user);
	    if (persistentInstance != null) {
	        s.delete(persistentInstance);
	        return true;
	    }
		return false;
	}

	public void editAdmin(String user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hqlUpdate = "update UserProfile set ISADMIN = 1 where USERNAME = :userid";
		@SuppressWarnings({ "deprecation", "unused" })
		int updatedEntities = session.createQuery( hqlUpdate )
		        .setString( "userid", user )
		        .executeUpdate();
		tx.commit();
	}
}
