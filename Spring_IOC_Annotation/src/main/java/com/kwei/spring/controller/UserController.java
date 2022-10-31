package com.kwei.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.kwei.spring.service.UserService;

// 設置IOC-Bean的id, 預設id為類型的小駝峰命名.
//@Controller("controller")
@Controller
public class UserController {
	
	@Autowired // 自動裝配-annotation無需使用set依賴注入
	//@Qualifier("userServiceImpl") //指定自動裝配的IOC中Bean的id
	private UserService userService; 

//	@Autowired
//	public UserController(UserService userService) {
//		super();
//		this.userService = userService;
//	}

	//@Autowired //M2:
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}

	public void saveUser() {
		userService.saveUser();
	}

}
