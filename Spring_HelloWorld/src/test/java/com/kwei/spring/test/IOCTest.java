package com.kwei.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kwei.spring.pojo.Amitofo;

public class IOCTest {

	@Test
	public void testIOC() {
		
		// ���IOC�e��
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		// ���IOC�e����bean��H
		Object obj = ioc.getBean("amitofo");
		Amitofo amitofo = (Amitofo) obj;
		amitofo.amitofo();
		
	}
	
}
