package com.rev.repo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rev.repo.bean.Topic;
import com.rev.repo.service.TopicService;

@RestController
public class TopicController {
	@Autowired
	private TopicService ts;

	@GetMapping(value="/topics")
	public ResponseEntity<List<Topic>> getAll() {
		List<Topic> comments = ts.getAll();
		return ResponseEntity.ok(comments);
	}
	
	@PostMapping(value="/topics")
	public ResponseEntity<Topic> postComment(@Validated @RequestBody Topic topic, Errors errors) {
		if (errors.hasErrors()) {
			return null;
		}
		ts.newTopic(topic);
		return ResponseEntity.ok(topic);
	}
}
