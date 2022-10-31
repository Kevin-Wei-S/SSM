package com.kwei.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.kwei.spring.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	public void saveUser() {
		System.out.println("新增用戶成功!");
	}
	
}
