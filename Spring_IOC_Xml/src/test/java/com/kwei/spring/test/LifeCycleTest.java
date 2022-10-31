package com.kwei.spring.test;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kwei.spring.pojo.Student;
import com.kwei.spring.pojo.User;

public class LifeCycleTest {

	/**
	 * 												  	  						
	 *  Bean的生命週期: 		 
	 *  實例化 -> 依賴注入 -> 後置處理器before 
	 *  				  -> 初始化 
	 *  				  -> 後置處理器after -> 銷毀(結束生命週期) 
	 *  
	 * 	before: postProcessBeforeInitialization()
	 * 	after: postProcessAfterInitialization()
	 * 	初始化: 須通過屬性init-method
	 *  銷毀: 須通過屬性destroy-method
	 *  
	 *  注意: 
	 *  	若Bean的作用域為單例時: Bean的生命週期前三步驟會在獲取ioc容器時完成,
	 *  						   而會在ioc關閉時銷毀.
	 *  	若Bean的作用域為多例時: Bean的生命週期前三步驟會在獲取Bean時完成,
	 *  						   不會在ioc關閉時銷毀, 多例時由其他對象接管.
	 */
	
	@Test
	public void testBeanLifeCycle() {
		// ConfigurableApplicationContext為ApplicationContext的子接口, 
		// 其中擴展了刷新及關閉容器的方法.
		ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-bean-lifecycle.xml");
		User user = ioc.getBean(User.class);
		System.out.println(user);
		
		ioc.close();
	}
	
}
