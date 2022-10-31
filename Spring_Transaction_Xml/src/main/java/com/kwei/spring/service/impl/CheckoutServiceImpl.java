package com.kwei.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kwei.spring.service.BookService;
import com.kwei.spring.service.CheckoutService;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	@Autowired
	private BookService bookService;

	@Override
	public void checkout(Integer userId, Integer[] bookIds) {
		for(Integer bookId : bookIds) {
			bookService.buyBook(userId, bookId);
		}
	}
	
}
