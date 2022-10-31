package com.kwei.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kwei.spring.pojo.User;

public class FactoryBeanTest {

	@Test
	public void testUserFactoryBean() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_factory.xml");
		User user = ioc.getBean(User.class);
		System.out.println(user);
		
	}
	
	
}
