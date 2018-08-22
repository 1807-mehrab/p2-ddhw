package com.rev.repo.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rev.repo.bean.UserProfile;
import com.rev.repo.bean.UserLogin;
import com.rev.repo.service.UserProfileService;

@CrossOrigin
@RestController
public class LoginController {
	@Autowired
	private UserProfileService ups;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<UserProfile> authenticator(@RequestBody UserLogin ul) {
		UserProfile user_get = new UserProfile(ul);
		UserProfile user_resp= ups.getOne(user_get);
		return ResponseEntity.ok(user_resp);
	}
}
