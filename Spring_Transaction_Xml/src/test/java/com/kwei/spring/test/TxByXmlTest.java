package com.kwei.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kwei.spring.controller.BookController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx_xml.xml")
public class TxByXmlTest {

	@Autowired
	private BookController bookController;
	
	@Test
	public void testBuyBook() {
		
		bookController.buyBook(1, 1);
		
	}
	
}
