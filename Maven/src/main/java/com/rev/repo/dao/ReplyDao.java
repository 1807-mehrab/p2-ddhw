package com.rev.repo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rev.repo.bean.Reply;

@Transactional
@Repository
public class ReplyDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Reply> getReplies(int topicId) {
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from Replies where TOPICID = :id").setInteger("id", topicId).list();
	}
	
	public Reply newReply(Reply r) {
		Session s = sessionFactory.getCurrentSession();
		s.save(r);
		return r;
	}
	
	public boolean adminDeleteReply(int reply) {
		Session s = sessionFactory.getCurrentSession();
		Object persistentInstance = s.load(Reply.class, reply);
	    if (persistentInstance != null) {
	        s.delete(persistentInstance);
	        return true;
	    }
		return false;
	}
}
