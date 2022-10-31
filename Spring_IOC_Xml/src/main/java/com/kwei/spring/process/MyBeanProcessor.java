package com.kwei.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanProcessor implements BeanPostProcessor {
	
	// ����k�bBean���ͩR�g����l�Ƥ��e�Ӱ���
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanProcessor-��m�B�z��-postProcessBeforeInitialization()");
		return bean; 
	}
	
	// ����k�bBean���ͩR�g����l�Ƥ���Ӱ���
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanProcessor-��m�B�z��-postProcessAfterInitialization()");
		return bean;
	}
	
}
