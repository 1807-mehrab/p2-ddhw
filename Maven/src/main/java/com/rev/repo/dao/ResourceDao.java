package com.rev.repo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rev.repo.bean.Reply;
import com.rev.repo.bean.Resource;
import com.rev.repo.bean.Topic;

@Transactional
@Repository
public class ResourceDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Resource getResource(Topic t) {
		Session s = sessionFactory.getCurrentSession();
		Resource r = null;
		List<Resource> resources = s.createQuery("from Resources where CONTENTID = :id").setInteger("id", t.getContentId()).list();
		
		if (!resources.isEmpty()) {
			r = resources.get(0);
		}
		
		return r;
	}
	
	public Resource getResource(Reply rpl) {
		Session s = sessionFactory.getCurrentSession();
		Resource r = null;
		List<Resource> resources = s.createQuery("from Resources where CONTENTID = :id").setInteger("id", rpl.getContentId()).list();
		
		if (!resources.isEmpty()) {
			r = resources.get(0);
		}
		
		return r;
	}
	
	public void newResource(Resource r) {
		Session s = sessionFactory.getCurrentSession();
		s.save(r);
	}
}
