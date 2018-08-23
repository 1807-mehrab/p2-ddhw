package com.rev.repo.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rev.repo.bean.Reply;
import com.rev.repo.bean.Resource;

@Transactional
@Repository
public class ReplyDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked") //seq.next val forautoincrement for int ids
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

	//join reply and resources to change content
	public void adminEditReply(int replyId, Resource content) {
		Session s = sessionFactory.getCurrentSession();
		Reply instance = s.load(Reply.class, replyId);
		instance.setContent(content);
		s.saveOrUpdate(instance);
	}

	public boolean flag(int replyId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hqlUpdate = "update REPLY set REPLYFLAG = 1 where REPLYID = :rid";
		int updatedEntities = session.createQuery( hqlUpdate )
		        .setString( "rid", replyId )
		        .executeUpdate();
		tx.commit();
		return false;
	}

	public List<Reply> getAllFlagged() {
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from Replies where REPLYFLAG = 1").list();
	}
}
