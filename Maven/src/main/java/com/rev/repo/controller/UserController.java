package com.rev.repo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rev.repo.bean.UserInfo;
import com.rev.repo.bean.UserProfile;
import com.rev.repo.service.UserInfoService;
import com.rev.repo.service.UserProfileService;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserInfoService uis;
	
	@Autowired
	private UserProfileService ups;

	@PostMapping(value = "/user/{id}")
	public ResponseEntity<UserInfoService> editProfile(@Validated @RequestBody UserInfo ui, Errors errors) {
		if (errors.hasErrors()) {
			return null;
		}
		uis.userInfoEdit(ui);
		return ResponseEntity.ok(uis);
	}

	@GetMapping(value = "/user/{id}")
	public ResponseEntity<UserInfoService> getProfile(@Validated @RequestBody UserInfo ui, Errors errors) {
		if (errors.hasErrors()) {
			return null;
		}
		uis.getOne(ui.getUserId().getUser());
		return ResponseEntity.ok(uis);
	}
	
	@GetMapping(value="/admin/users")
	public ResponseEntity<UserProfileService> getUsers(@Validated @RequestBody UserProfile up, Errors errors) {
		if (errors.hasErrors()) {
			return null;
		}
		ups.getAll();
		return ResponseEntity.ok(ups);
	}
	
	@DeleteMapping(value="/admin/users/{id}")
	public ResponseEntity<UserProfileService> deleteUser(@PathVariable UserProfile up) {
		ups.deleteUser(up);
		return ResponseEntity.ok(ups);
	}
	
	@PostMapping(value="/admin/users/{id}")
	public ResponseEntity<UserProfileService> grantAdmin(@PathVariable UserProfile up) {
		ups.adminGrantAdmin(up);
		return ResponseEntity.ok(ups);
	}
}
