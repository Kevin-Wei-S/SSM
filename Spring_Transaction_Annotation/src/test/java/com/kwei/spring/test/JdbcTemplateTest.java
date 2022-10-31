package com.kwei.spring.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kwei.spring.pojo.User;

// ���w��e�������bSpring���������Ҥ��Ӱ���, 
// ���ɴN�i�H�q�L�`�J���覡�������IOC�e������Bean.
@RunWith(SpringJUnit4ClassRunner.class)
// �]�m��eSpring�������Ҫ��t�m���
@ContextConfiguration("classpath:spring_jdbc.xml")
public class JdbcTemplateTest {

	@Autowired
	private JdbcTemplate jt;
	
	
	@Test
	public void testGetSingleValue() {
		String sql = "select balance from t_user where user_id = ?";
		Integer balance = jt.queryForObject(sql, Integer.class, 1);
		System.out.println(balance);
	}
	
	@Test
	public void getCount() {
		String sql = "select count(*) from t_user";
		Integer count = jt.queryForObject(sql, Integer.class);
		System.out.println(count);
	}
	
	@Test
	public void testGetAllUser() {
		String sql = "select * from t_user";
		List<User> list = jt.query(sql, new BeanPropertyRowMapper<>(User.class));
		list.forEach(System.out::println);
	}
	
	@Test
	public void getUserById() {
		String sql = "select * from t_user where id = ?";
		User user = jt.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 2);
		System.out.println(user);
	}
	
	@Test
	public void testInsert() {
		String sql = "insert into t_user values(null,?,?,?,?,?)";
		int result = jt.update(sql, "Amitofo", "back", 0, "0", "0");
		System.out.println(result);
	}
	
}
