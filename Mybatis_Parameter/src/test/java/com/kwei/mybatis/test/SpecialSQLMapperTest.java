package com.kwei.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.kwei.mybatis.mapper.SpecialSQLMapper;
import com.kwei.mybatis.pojo.User;
import com.kwei.mybatis.utils.SqlSessionUtil;

public class SpecialSQLMapperTest {

	@Test
	public void testInsertUser() throws IOException {
		SqlSession ss = SqlSessionUtil.getSqlSession();
		SpecialSQLMapper mapper = ss.getMapper(SpecialSQLMapper.class);
		User user = new User(null, "QWERT", "0000", 20, "M", "QWERT@gmail.com");
		mapper.insertUser(user);
		System.out.println(user);
	}

	@Test
	public void testGetUserList() {

		SqlSession ss = SqlSessionUtil.getSqlSession();
		SpecialSQLMapper mapper = ss.getMapper(SpecialSQLMapper.class);
		List<User> list = mapper.getUserList("t_user");
		list.forEach(System.out::println);

	}

	@Test
	public void testDeleteMoreUser() {
		SqlSession ss = SqlSessionUtil.getSqlSession();
		SpecialSQLMapper mapper = ss.getMapper(SpecialSQLMapper.class);
		String str = "";
		for (int i = 21; i <= 28; i++) {
			if (i == 28) {
				str += i;
				break;
			}
			str += i + ",";
		}
		mapper.deleteMoreUser(str);
	}

	@Test
	public void testGetUserByLike() {
		SqlSession ss = SqlSessionUtil.getSqlSession();
		SpecialSQLMapper mapper = ss.getMapper(SpecialSQLMapper.class);
		List<User> list = mapper.getUserByLike("A");
		list.forEach(System.out::println);
	}

	@Test
	public void testJDBC() {

		try {
			Class.forName("");
			Connection conn = DriverManager.getConnection("", "", "");
//			String sql = "select * from t_user where username like '%?%'";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, "a");
			String sql = "insert into t_user values()";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.executeUpdate();
			ResultSet resultSet = ps.getGeneratedKeys();
			Integer id = null;
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
