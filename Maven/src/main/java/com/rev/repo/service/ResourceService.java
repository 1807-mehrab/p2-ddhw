package com.rev.repo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.repo.bean.Reply;
import com.rev.repo.bean.Resource;
import com.rev.repo.bean.Topic;
import com.rev.repo.dao.ResourceDao;

@Service
public class ResourceService {
	@Autowired
	ResourceDao dao;
	
	public void setDao(ResourceDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	public Resource getResource(Topic t) {
		return dao.getResource(t);
	}
	
	@Transactional
	public Resource getResource(Reply rpl) {
		return dao.getResource(rpl);
	}
	
	@Transactional
	public void newResource(Resource r) {
		dao.newResource(r);
	}
}
