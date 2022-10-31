package com.kwei.spring.aop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kwei.spring.aop.xml.Calculator;
import com.kwei.spring.aop.xml.CalculatorImpl;


public class AOPTest {

	@Test
	public void testAOPByXml() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("aop_xml.xml");
		Calculator proxy = ioc.getBean(Calculator.class);
		System.out.println(proxy.add(100,100));
		
	}
	
}
