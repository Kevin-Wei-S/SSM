package com.kwei.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kwei.spring.pojo.Amitofo;

public class IOCTest {

	@Test
	public void testIOC() {
		
		// 獲取IOC容器
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 獲取IOC容器的bean對象
		Object obj = ioc.getBean("amitofo");
		Amitofo amitofo = (Amitofo) obj;
		amitofo.amitofo();
		
	}
	
}
