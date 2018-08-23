package com.rev.repo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rev.repo.bean.Reply;
import com.rev.repo.bean.Topic;
import com.rev.repo.bean.UserInfo;
import com.rev.repo.service.ReplyService;
import com.rev.repo.service.UserInfoService;

@RestController
public class ReplyController {
	@Autowired
	ReplyService rs;
	
	@GetMapping(value="/topic/posts")
	public ResponseEntity<List<Reply>> getAllReply(@PathVariable Topic topic) {
		List<Reply> posts = rs.getAll(topic.getTopicId());
		return ResponseEntity.ok(posts);
	}
	
	@PostMapping(value="/topics/posts")
	public ResponseEntity<Reply> postReply(@Validated @RequestBody Reply r, Errors errors) {
		if (errors.hasErrors()) {
			return null;
		}
		rs.newReply(r);
		return ResponseEntity.ok(r);
	}
	
	@PostMapping(value="/posts/flag")
	public ResponseEntity<Reply> flagReply(@Validated @RequestBody Reply r, Errors errors) {
		if (errors.hasErrors()) {
			return null;
		}
		rs.flagReply(r);
		return ResponseEntity.ok(r);
	}
	
	@DeleteMapping(value="/admin/posts/{id}")
	public ResponseEntity<Reply> deleteReply(@PathVariable Reply reply){
		rs.adminDeleteReply(reply);
		return ResponseEntity.ok(reply);
	}
	
	@PostMapping(value = "/admin/posts/{id}")
	public ResponseEntity<Reply> editProfile(@Validated @RequestBody Reply reply, Errors errors) {
		if (errors.hasErrors()) {
			return null;
		}
		rs.adminEditReply(reply);
		return ResponseEntity.ok(reply);
	}
	
	@GetMapping(value="/admin/posts/")
	public ResponseEntity<List<Reply>> getFlagged() {
		List<Reply> posts = rs.getFlaggedReply();
		return ResponseEntity.ok(posts);
	}
}
