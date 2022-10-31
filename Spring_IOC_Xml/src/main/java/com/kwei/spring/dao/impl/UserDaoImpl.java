package com.kwei.spring.dao.impl;

import javax.sql.DataSource;

import com.kwei.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {

//	private DataSource dataSource;
//
//	public DataSource getDataSource() {
//		return dataSource;
//	}
//
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}

	@Override
	public void saveUser() {
		System.out.println("新增成功!");
	}
	
}
