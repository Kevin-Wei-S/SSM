package com.kwei.spring.controller;

import com.kwei.spring.service.UserService;

public class UserController {
	// �@��g�k
//	private UserService userService = new UserServiceImpl();
	// �浹IOC�e���޲z�g�k
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
