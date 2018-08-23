package com.rev.repo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rev.repo.bean.UserProfile;
import com.rev.repo.bean.UserLogin;
import com.rev.repo.service.UserProfileService;

@CrossOrigin
@RestController
public class LoginController {
	@Autowired
	private UserProfileService ups;

	@RequestMapping(value = "/userprofiles", method = RequestMethod.POST)
	public ResponseEntity<UserProfile> authenticator(@RequestBody UserLogin ul) {
		System.out.println("you made it, " + ul.getUser() + "!");
		UserProfile user_get = new UserProfile(ul);
		UserProfile user_resp = ups.authentication(user_get);
		return ResponseEntity.ok(user_resp);
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<UserProfile> signup(@RequestBody UserLogin ul) {
		UserProfile user_get = new UserProfile(ul);
		UserProfile user_resp = ups.newUserProfile(user_get);
		return ResponseEntity.ok(user_resp);
	}
}
