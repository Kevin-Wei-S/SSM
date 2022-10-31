package com.kwei.spring.aop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kwei.spring.aop.annotation.Calculator;

public class AOPTest {

	@Test
	public void testAOPByAnnotation() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("aop_annotation.xml");
		Calculator proxy = ioc.getBean(Calculator.class);
		System.out.println(proxy.sub(100, 100));
		
	}
	
}
