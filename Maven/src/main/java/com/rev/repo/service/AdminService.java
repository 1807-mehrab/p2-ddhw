package com.rev.repo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.repo.bean.Reply;
import com.rev.repo.dao.ReplyDao;

@Service
public class AdminService {
//	4) admin can edit post
//	5) promote users to admin
//	6) create user accounts / admin account // radio to distinguish type
//	7) view flagged post
	
	@Autowired
	ReplyDao dao;
	
	public void setDao(ReplyDao dao) {
		this.dao = dao;
	}
	
	
	@Transactional
	public Boolean deleteReply(Reply reply) {
		return dao.adminDeleteReply(reply.getReplyId());
	}
}
