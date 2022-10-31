package com.kwei.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.kwei.spring.service.UserService;

// �]�mIOC-Bean��id, �w�]id���������p�m�p�R�W.
//@Controller("controller")
@Controller
public class UserController {
	
	@Autowired // �۰ʸ˰t-annotation�L�ݨϥ�set�̿�`�J
	//@Qualifier("userServiceImpl") //���w�۰ʸ˰t��IOC��Bean��id
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
