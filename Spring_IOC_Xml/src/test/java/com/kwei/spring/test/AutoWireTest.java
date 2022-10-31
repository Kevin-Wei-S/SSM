package com.kwei.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kwei.spring.controller.UserController;

public class AutoWireTest {

	/**
	 *  自動裝配:
	 *  	根據指定的策略, 在IOC容器中匹配該策略的Bean,
	 *  	自動為Bean中的類類型或接口類型的屬性賦值
	 * 
	 * 	自動裝配的策略:
	 * 		Bean的autowire屬性:
	 * 			default: 不自動裝配, 即Bean中屬性不會自動匹配某個Bean為屬性賦值
	 * 					 此時屬性為默認值.
	 * 			no: 不自動裝配, 如上.
	 * 			byType: 根據類型, 找出匹配屬性類型的Bean進行賦值.
	 * 				注意:
	 * 				w. 若通過類型沒有找到任何一個類型匹配, 則不自動裝配, 屬性為默認值.
	 * 				s. 若通過類型找到多個匹配的Bean時, 會報NoUniqueBeanDefinitionException.
	 * 				總結: 使用byType實現自動裝配時, IOC容器有且只有一個類型匹配的Bean.
	 * 			byName: 根據名稱, 找出匹配成員變量名的Bean進行賦值.
	 * 				總結: 當byType匹配到多個Bean符合, 就用byName來自動裝配.
	 * 			constructor: 基本不用, 省略.			
	 * 		
	 */
	
	@Test
	public void testUserController() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_autowire_xml.xml"); 
		UserController userController = ioc.getBean(UserController.class);
		userController.saveUser();
		
	}
	
	
}
