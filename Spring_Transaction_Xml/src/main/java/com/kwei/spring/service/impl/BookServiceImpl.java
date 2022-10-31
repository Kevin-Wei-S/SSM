package com.kwei.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kwei.spring.dao.BookDao;
import com.kwei.spring.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;
	
	public void buyBook(Integer userId, Integer bookId) {
		
//		try {
//			TimeUnit.SECONDS.sleep(5);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		// �d�߹Ϯѻ���
		Integer price = bookDao.getPriceByBookId(bookId);
		// ��s�ϮѮw�s
		bookDao.updateStockByBookId(bookId);
		// ��s�Τ�l�B
		bookDao.updateBalanceByUserId(userId, price);
		//System.out.println(1/0);
	}
	
}