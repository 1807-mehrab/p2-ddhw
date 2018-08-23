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
	public Reply newReply(Reply r) {
		return dao.newReply(r);
	}
	
//	admin can delete post--
	@Transactional
	public Boolean adminDeleteReply(Reply reply) {
		return dao.adminDeleteReply(reply.getReplyId());
	}
	
//	admin can edit post--
	@Transactional
	public void adminEditReply(Reply reply) {
		dao.adminEditReply(reply.getReplyId(), reply.getContent());
	}

	public boolean flagReply(Reply r) {
		return dao.flag(r.getReplyId());
	}

// admin view flagged--
	public List<Reply> getFlaggedReply() {
		return dao.getAllFlagged();
	}
	
	
}
