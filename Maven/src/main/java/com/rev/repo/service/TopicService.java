package com.rev.repo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.repo.bean.Topic;
import com.rev.repo.bean.UserProfile;
import com.rev.repo.dao.TopicDao;

@Service
public class TopicService {
	@Autowired
	TopicDao dao;
	
	public void setDao(TopicDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	public List<Topic> getAll() {
		return dao.getTopics();
	}
	
	@Transactional
	public List<Topic> getUserAll(UserProfile user) {
		return dao.getTopics(user.getUser());
	}
	
	@Transactional
	public Topic newTopic(Topic t) {
		return dao.newTopic(t);
	}
	
}
