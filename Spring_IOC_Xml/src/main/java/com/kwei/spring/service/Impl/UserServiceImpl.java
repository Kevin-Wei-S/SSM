package com.kwei.spring.service.Impl;

import com.kwei.spring.dao.UserDao;
import com.kwei.spring.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void saveUser() {
		userDao.saveUser();
	}
	
}
