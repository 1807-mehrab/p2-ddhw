package com.rev.repo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rev.repo.bean.Topic;

@Transactional
@Repository
public class TopicDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Topic> getTopics() {
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from Topic").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Topic> getTopics(String userId) {
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from Topic where USERID = :id").setString("id", userId).list();
	}
	
	@SuppressWarnings("unchecked")
	public Topic getTopic(int topicId) {
		Session s = sessionFactory.getCurrentSession();
		Topic t = null;
		List<Topic> topics = s.createQuery("from Topic where TOPICID = :id").setInteger("id", topicId).list();
		
		if (!topics.isEmpty()) {
			t = topics.get(0);
		}
		
		return t;
	}

	public Topic newTopic(Topic t) {
		Session s = sessionFactory.getCurrentSession();
		s.save(t);
		return t;
	}
}
