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
	
	@Transactional(
			// readOnly = true // 僅適合在所有操作都為查詢時, 作用: 優化數據庫搜尋
			// timeout = 3     // 如果超時就回滾, 並且拋出異常.
			// 根據特定異常訊息不回滾
			// noRollbackFor = java.lang.ArithmeticException.class 
			// noRollbackForClassName = "java.lang.ArithmeticException"
			// 隔離級別
			// isolation = Isolation.DEFAULT
			// 事務傳播
			// Propagation.REQUIRES_NEW: 使用被調用者本身事務, 而非調用此方法的事務.
			propagation = Propagation.REQUIRES_NEW
			
	)
	public void buyBook(Integer userId, Integer bookId) {
		
//		try {
//			TimeUnit.SECONDS.sleep(5);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		// 查詢圖書價格
		Integer price = bookDao.getPriceByBookId(bookId);
		// 更新圖書庫存
		bookDao.updateStockByBookId(bookId);
		// 更新用戶餘額
		bookDao.updateBalanceByUserId(userId, price);
		//System.out.println(1/0);
	}
	
}
