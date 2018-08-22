package com.rev.repo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.repo.bean.Resource;
import com.rev.repo.dao.ResourceDao;

@Service
public class ResourceService {
	@Autowired
	ResourceDao dao;
	
	public void setDao(ResourceDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	public Resource newResource(Resource r) {
		return dao.newResource(r);
	}
	
	@Transactional 
	public Resource getResource(int id) {
		return dao.getResource(id);
	}
}
