package com.rev.repo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rev.repo.bean.Topic;
import com.rev.repo.bean.UserProfile;
import com.rev.repo.service.TopicService;

@RestController
public class TopicController {
	@Autowired
	private TopicService ts;

	@GetMapping(value="/topics")
	public ResponseEntity<List<Topic>> getAll() {
		List<Topic> topic = ts.getAll();
		return ResponseEntity.ok(topic);
	}
	
	@PostMapping(value="/topics")
	public ResponseEntity<Topic> postTopic(@Validated @RequestBody Topic topic, Errors errors) {
		if (errors.hasErrors()) {
			return null;
		}
		ts.newTopic(topic);
		return ResponseEntity.ok(topic);
	}
	
	@GetMapping(value="/user/topics")
	public ResponseEntity<List<Topic>> getUserAll(@PathVariable UserProfile user) {
		List<Topic> topic = ts.getUserAll(user);
		return ResponseEntity.ok(topic);
	}
}
