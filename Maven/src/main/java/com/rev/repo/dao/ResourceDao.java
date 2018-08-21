package com.rev.repo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rev.repo.bean.Resource;

@Transactional
@Repository
public class ResourceDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public Resource getResource(int id) {
		Session s = sessionFactory.getCurrentSession();
		Resource r = null;
		List<Resource> resources = s.createQuery("from Resources where CONTENTID = :id").setInteger("id", id).list();
		
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
