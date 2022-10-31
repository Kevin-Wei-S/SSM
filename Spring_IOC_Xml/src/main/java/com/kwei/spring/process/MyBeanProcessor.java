package com.kwei.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanProcessor implements BeanPostProcessor {
	
	// 此方法在Bean的生命週期初始化之前來執行
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanProcessor-後置處理器-postProcessBeforeInitialization()");
		return bean; 
	}
	
	// 此方法在Bean的生命週期初始化之後來執行
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanProcessor-後置處理器-postProcessAfterInitialization()");
		return bean;
	}
	
}
