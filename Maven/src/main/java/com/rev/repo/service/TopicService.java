package com.rev.repo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.repo.bean.Topic;
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
	public List<Topic> getAll(String userId) {
		return dao.getTopics(userId);
	}
	
	@Transactional
	public Topic getOne(int topicId) {
		return dao.getTopic(topicId);
	}
	
	@Transactional
	public Topic newTopic(Topic t) {
		return dao.newTopic(t);
	}
}
