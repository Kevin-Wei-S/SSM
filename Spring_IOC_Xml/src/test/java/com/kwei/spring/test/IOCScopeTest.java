package com.kwei.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kwei.spring.pojo.Student;

public class IOCScopeTest {

	@Test
	public void testIOCScope() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_scope.xml");
		Student student1 = ioc.getBean(Student.class);
		Student student2 = ioc.getBean(Student.class);
		
		System.out.println(student1 == student2);
		
	}
	
}
