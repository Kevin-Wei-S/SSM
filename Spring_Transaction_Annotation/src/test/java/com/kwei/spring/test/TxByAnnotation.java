package com.kwei.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kwei.spring.controller.BookController;

/*
 * 	�n�����ưȪ��t�m�B�J:
 * 		1. �bSpring���t�m��󤤰t�m�ưȺ޲z��
 * 		2. �bSpring���t�m��󤤶}�ҨưȪ������X��
 *  
 *  �b�ݭn�Q�ưȺ޲z����k�����W�[�W@Transational����, �Ӥ�k�������Ҧ���k�����J�I
 *  �B�Q�ưȺ޲z.
 *  
 *  @Transactional���ѼХܪ���m:
 *  	1. �Хܦb��k�W: ����k�|�Q�ưȺ޲z
 *  	2. �Хܦb���W: �����Ҧ�����k���|�Q�ưȺ޲z
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
// JDK_17 �P Spring_5.3.1 �����|���ۮe
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
