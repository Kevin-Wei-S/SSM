package com.kwei.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.kwei.mybatis.mapper.UserMapper;
import com.kwei.mybatis.pojo.User;
import com.kwei.mybatis.utils.SqlSessionUtil;

/**
 * 
 * Date: 2022年8月9日下午4:45:26 Author: K-Wei Email: a8566248@gmail.com Description:
 *
 */
public class MyBatisTest {

	@Test
	public void testGetAllUser() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		List<User> list = mapper.getAllUser();
		list.forEach(System.out::println);
		
	}
	
	@Test
	public void testGetUserById() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		User user = mapper.getUserById();
		System.out.println(user);
		System.out.println(user.getClass());
		
	}
	
	@Test
	public void testDeleteUser() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		int result = mapper.deleteUser();
		System.out.println("Result: " + result);
		
	}
	
	@Test
	public void testUpdateUser() {
		SqlSession ss = SqlSessionUtil.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		mapper.updateUser();
		
		ss.close();
	}
	
	@Test
	public void testInsertUser() {
		SqlSession ss = SqlSessionUtil.getSqlSession();
		UserMapper mapper = ss.getMapper(UserMapper.class);
		int result = mapper.insertUser();
		System.out.println("結果: " + result);
		ss.close();
	}

	@Test
	public void insertUser() throws IOException {
		// 獲取核心配置文件的輸入流
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

		// 獲取SqlSessionFactoryBuilder對象
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

		// 獲取SqlSessionFactory對象
		SqlSessionFactory ssf = ssfb.build(is);

		// 獲取sql的會話對象SqlSession, 是MyBatis提供操作數據庫的對象
		// 不會自動提交
//		SqlSession ss = ssf.openSession();

		// 獲取sql的會話對象SqlSession, 是MyBatis提供操作數據庫的對象
		// 會自動提交
		SqlSession ss = ssf.openSession(true);

		// 獲取UserMapper的代理實現類對象 (常用)
		UserMapper mapper = ss.getMapper(UserMapper.class);

		// 通過SQL語句的唯一標示找到SQL並執行, 唯一標示為namespace.sqlId (不常用)
//		int result = ss.insert("com.kwei.mybatis.mapper.UserMapper.insertUser");

		// 調用UserMapper代理實現類實現的抽象方法
		int result = mapper.insertUser();
		System.out.println("新增結果: " + result);

//		if(result == 1) {
		// 提交事務(手動)
//			ss.commit();
//		}

		// 關閉SqlSession資源
		ss.close();

	}

}
