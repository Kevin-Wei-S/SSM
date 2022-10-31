package com.kwei.spring.test;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kwei.spring.pojo.Student;
import com.kwei.spring.pojo.User;

public class LifeCycleTest {

	/**
	 * 												  	  						
	 *  Bean���ͩR�g��: 		 
	 *  ��Ҥ� -> �̿�`�J -> ��m�B�z��before 
	 *  				  -> ��l�� 
	 *  				  -> ��m�B�z��after -> �P��(�����ͩR�g��) 
	 *  
	 * 	before: postProcessBeforeInitialization()
	 * 	after: postProcessAfterInitialization()
	 * 	��l��: ���q�L�ݩ�init-method
	 *  �P��: ���q�L�ݩ�destroy-method
	 *  
	 *  �`�N: 
	 *  	�YBean���@�ΰ쬰��Ү�: Bean���ͩR�g���e�T�B�J�|�b���ioc�e���ɧ���,
	 *  						   �ӷ|�bioc�����ɾP��.
	 *  	�YBean���@�ΰ쬰�h�Ү�: Bean���ͩR�g���e�T�B�J�|�b���Bean�ɧ���,
	 *  						   ���|�bioc�����ɾP��, �h�ҮɥѨ�L��H����.
	 */
	
	@Test
	public void testBeanLifeCycle() {
		// ConfigurableApplicationContext��ApplicationContext���l���f, 
		// �䤤�X�i�F��s�������e������k.
		ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-bean-lifecycle.xml");
		User user = ioc.getBean(User.class);
		System.out.println(user);
		
		ioc.close();
	}
	
}
