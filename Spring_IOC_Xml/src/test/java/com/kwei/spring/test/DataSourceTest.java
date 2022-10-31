package com.kwei.spring.test;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;

public class DataSourceTest {

	@Test
	public void testDruid() throws SQLException {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_datasource.xml");
		DruidDataSource dataSource = ioc.getBean(DruidDataSource.class);
		System.out.println(dataSource.getConnection());
		
	}
	
}
