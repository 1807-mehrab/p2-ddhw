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
	
	public List<Reply> getReplies(int topicId) {
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from Replies where TOPICID = :id").setInteger("id", topicId).list();
	}
	
	public void newReply(int replyId, int topicId, String userId, int contentId) {
		Session s = sessionFactory.getCurrentSession();
		s.save(new Reply(replyId, topicId, userId, contentId));
	}
}
