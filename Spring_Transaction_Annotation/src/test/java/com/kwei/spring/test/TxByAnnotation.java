package com.kwei.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kwei.spring.controller.BookController;

/*
 * 	聲明式事務的配置步驟:
 * 		1. 在Spring的配置文件中配置事務管理器
 * 		2. 在Spring的配置文件中開啟事務的註解驅動
 *  
 *  在需要被事務管理的方法或類上加上@Transational註解, 該方法或類中所有方法為切入點
 *  且被事務管理.
 *  
 *  @Transactional註解標示的位置:
 *  	1. 標示在方法上: 此方法會被事務管理
 *  	2. 標示在類上: 類中所有的方法都會被事務管理
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
// JDK_17 與 Spring_5.3.1 有機會不相容
@ContextConfiguration("classpath:tx_annotation.xml")
public class TxByAnnotation {

	@Autowired
	private BookController bookController;
	
	
	@Test
	public void testCheckout() {
		
		Integer userId = 1;
		Integer[] bookIds = new Integer[] {1, 2};
		
		bookController.checkout(userId, bookIds);
		
	}
	
	@Test
	public void testBuyBook() {
		bookController.buyBook(1, 2);
	}
	
}
