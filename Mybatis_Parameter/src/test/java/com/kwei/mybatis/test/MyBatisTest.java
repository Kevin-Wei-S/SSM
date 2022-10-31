package com.kwei.mybatis.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.kwei.mybatis.mapper.UserMapper;
import com.kwei.mybatis.pojo.User;
import com.kwei.mybatis.utils.SqlSessionUtil;

public class MyBatisTest {
	
	@Test
	public void testCheckLoginByParam() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		User user = mapper.checkLoginByParam("Amitofo", "0");
		System.out.println(user);
		
	}
	
	@Test
	public void testInsertUser() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		User user = new User(null, "WSX", "QAZ", 18, "S", "WSX@gmail.com");
		mapper.insertUser(user);
		
	}
	
	@Test
	public void testCheckLoginByMap() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		User user = mapper.checkLoginByMap(Map.of("key0", "Amitofo", "key1", "0"));
		System.out.println(user);
		
	}
	
	@Test
	public void testCheckLogin() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		User user = mapper.checkLogin("Amitofo", "0");
		System.out.println(user);
		
	}

	@Test
	public void testGetUserByUsername() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		User user = mapper.getUserByUsername("Amitofo");
		System.out.println(user);
		User user1 = mapper.getUserByUsername("Cruise");
		System.out.println(user1);
		
	}
	
	@Test
	public void getAllUsers() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		List<User> list = mapper.getAllUsers();
		list.forEach(System.out::println);
		
	}
 	
	
}
