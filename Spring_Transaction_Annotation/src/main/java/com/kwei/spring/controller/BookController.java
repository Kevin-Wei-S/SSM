package com.kwei.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kwei.spring.service.BookService;
import com.kwei.spring.service.CheckoutService;
import com.kwei.spring.service.impl.BookServiceImpl;

@Controller
public class BookController {

	@Autowired
	private BookService bookService = new BookServiceImpl();
	@Autowired
	private CheckoutService checkoutService;
	
	public void buyBook(Integer userId, Integer bookId) {
		bookService.buyBook(userId, bookId);
	}
	
	public void checkout(Integer userId, Integer[] bookIds) {
		checkoutService.checkout(userId, bookIds);
	}
	
	
}
