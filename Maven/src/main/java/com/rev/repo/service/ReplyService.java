package com.rev.repo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.repo.bean.Reply;
import com.rev.repo.dao.ReplyDao;

@Service
public class ReplyService {
	@Autowired
	ReplyDao dao;

	public void setDao(ReplyDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	public List<Reply> getAll(int topicId) {
		return dao.getReplies(topicId);
	}
	
	@Transactional
	public void newReply(int replyId, int topicId, String userId, int contentId) {
		dao.newReply(replyId, topicId, userId, contentId);
	}
}
