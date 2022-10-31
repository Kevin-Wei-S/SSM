package com.kwei.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kwei.spring.controller.UserController;

public class AutoWireTest {

	/**
	 *  �۰ʸ˰t:
	 *  	�ھګ��w������, �bIOC�e�����ǰt�ӵ�����Bean,
	 *  	�۰ʬ�Bean�����������α��f�������ݩʽ��
	 * 
	 * 	�۰ʸ˰t������:
	 * 		Bean��autowire�ݩ�:
	 * 			default: ���۰ʸ˰t, �YBean���ݩʤ��|�۰ʤǰt�Y��Bean���ݩʽ��
	 * 					 �����ݩʬ��q�{��.
	 * 			no: ���۰ʸ˰t, �p�W.
	 * 			byType: �ھ�����, ��X�ǰt�ݩ�������Bean�i����.
	 * 				�`�N:
	 * 				w. �Y�q�L�����S��������@�������ǰt, �h���۰ʸ˰t, �ݩʬ��q�{��.
	 * 				s. �Y�q�L�������h�Ӥǰt��Bean��, �|��NoUniqueBeanDefinitionException.
	 * 				�`��: �ϥ�byType��{�۰ʸ˰t��, IOC�e�����B�u���@�������ǰt��Bean.
	 * 			byName: �ھڦW��, ��X�ǰt�����ܶq�W��Bean�i����.
	 * 				�`��: ��byType�ǰt��h��Bean�ŦX, �N��byName�Ӧ۰ʸ˰t.
	 * 			constructor: �򥻤���, �ٲ�.			
	 * 		
	 */
	
	@Test
	public void testUserController() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_autowire_xml.xml"); 
		UserController userController = ioc.getBean(UserController.class);
		userController.saveUser();
		
	}
	
	
}
