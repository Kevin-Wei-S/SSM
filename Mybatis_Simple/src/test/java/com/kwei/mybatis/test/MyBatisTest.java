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
 * Date: 2022�~8��9��U��4:45:26 Author: K-Wei Email: a8566248@gmail.com Description:
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
		System.out.println("���G: " + result);
		ss.close();
	}

	@Test
	public void insertUser() throws IOException {
		// ����֤߰t�m��󪺿�J�y
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

		// ���SqlSessionFactoryBuilder��H
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

		// ���SqlSessionFactory��H
		SqlSessionFactory ssf = ssfb.build(is);

		// ���sql���|�ܹ�HSqlSession, �OMyBatis���Ѿާ@�ƾڮw����H
		// ���|�۰ʴ���
//		SqlSession ss = ssf.openSession();

		// ���sql���|�ܹ�HSqlSession, �OMyBatis���Ѿާ@�ƾڮw����H
		// �|�۰ʴ���
		SqlSession ss = ssf.openSession(true);

		// ���UserMapper���N�z��{����H (�`��)
		UserMapper mapper = ss.getMapper(UserMapper.class);

		// �q�LSQL�y�y���ߤ@�Хܧ��SQL�ð���, �ߤ@�Хܬ�namespace.sqlId (���`��)
//		int result = ss.insert("com.kwei.mybatis.mapper.UserMapper.insertUser");

		// �ե�UserMapper�N�z��{����{����H��k
		int result = mapper.insertUser();
		System.out.println("�s�W���G: " + result);

//		if(result == 1) {
		// ����ư�(���)
//			ss.commit();
//		}

		// ����SqlSession�귽
		ss.close();

	}

}
