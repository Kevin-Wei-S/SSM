package com.kwei.spring.service;

public interface CheckoutService {
	/**
	 *  ���b
	 * @param userId
	 * @param bookIds
	 */
	void checkout(Integer userId, Integer[] bookIds);
	
}
