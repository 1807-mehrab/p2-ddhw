package com.rev.repo.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.rev.repo.config.HibernateConfig;
import com.rev.repo.service.UserInfoService;

public class Driver {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

		UserInfoService userInfoService = context.getBean("userInfoService", UserInfoService.class);
		//userInfoService.newUserInfo("user3", "worsememe@meme.com");
		System.out.println(userInfoService.getAll());
		System.out.println(userInfoService.getOne("user1"));
		System.out.println(userInfoService.getOne("user3"));

		context.close();
	}
}
