package com.kwei.mybatis.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.kwei.mybatis.mapper.SelectMapper;
import com.kwei.mybatis.pojo.User;
import com.kwei.mybatis.utils.SqlSessionUtil;

public class SelectMapperTest {
	
	@Test
	public void getAllUsersToMap() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		SelectMapper mapper = ss.getMapper(SelectMapper.class);
		Map<String,Object> map = mapper.getAllUsersToMap();
		for(Map.Entry<String,Object> entry : map.entrySet()) {
			System.out.println(entry);
		}
		
	}
	
//	@Test
//	public void testGetAllUsersToMap() {
//		SqlSession ss = SqlSessionUtil.getSqlSession();
//		SelectMapper mapper = ss.getMapper(SelectMapper.class);
//		List<Map<String,Object>> list = mapper.getAllUsersToMap();
//		list.forEach(System.out::println);
//	}
	
	@Test
	public void testGetUserByIdToMap() {
		SqlSession ss = SqlSessionUtil.getSqlSession();
		SelectMapper mapper = ss.getMapper(SelectMapper.class);
		Map<String,Object> map = mapper.getUserByIdToMap(3);
		// {password=0, gender=, id=3, age=0, email=, username=Amitofo}
		System.out.println(map);
	}
	
	@Test
	public void testGetCount() {
		SqlSession ss = SqlSessionUtil.getSqlSession();
		SelectMapper mapper = ss.getMapper(SelectMapper.class);
		Integer count = mapper.getCount();
		System.out.println(count);
	}
	
	@Test
	public void testGetAgeById() {
		SqlSession ss = SqlSessionUtil.getSqlSession();
		SelectMapper mapper = ss.getMapper(SelectMapper.class);
		Integer age = mapper.getAgeById(1);
		System.out.println(age);
	}
	
	@Test
	public void testGetUserByUsername() {
		SqlSession ss = SqlSessionUtil.getSqlSession();	
		SelectMapper mapper = ss.getMapper(SelectMapper.class);
		List<User> list = mapper.getUserByUsername("SSUtil");
		list.forEach(System.out::println);
	}
	
	@Test
	public void testGetUserById() {
		SqlSession ss = SqlSessionUtil.getSqlSession();
		SelectMapper mapper = ss.getMapper(SelectMapper.class);
		User user = mapper.getUserById(3);
		System.out.println(user);
	}
	
	@Test
	public void getAllUsers() {
		SqlSession ss = SqlSessionUtil.getSqlSession();
		SelectMapper mapper = ss.getMapper(SelectMapper.class);
		List<User> list = mapper.getAllUsers();
		list.forEach(System.out::println);
	}
	
}
