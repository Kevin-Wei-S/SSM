package com.kwei.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kwei.spring.dao.UserDao;
import com.kwei.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	//@Qualifier("userDaoImpl")
	private UserDao userDao;
	
	public void saveUser() {
		userDao.saveUser();
	}
	
	
}
