package com.kwei.spring.controller;

import com.kwei.spring.service.UserService;

public class UserController {
	// 一般寫法
//	private UserService userService = new UserServiceImpl();
	// 交給IOC容器管理寫法
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void saveUser() {
		userService.saveUser();
	}
	
}
