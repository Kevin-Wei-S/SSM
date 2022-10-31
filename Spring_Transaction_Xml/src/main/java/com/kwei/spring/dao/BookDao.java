package com.kwei.spring.dao;

public interface BookDao {

	/**
	 *  根據圖書的id查詢圖書價格
	 * @param bookId
	 * @return
	 */
	Integer getPriceByBookId(Integer bookId);

	/**
	 *  根據圖書的id更新圖書庫存
	 * @param bookId
	 */
	void updateStockByBookId(Integer bookId);

	/**
	 *  根據用戶的id更新用戶餘額
	 * @param userId
	 * @param price
	 */
	void updateBalanceByUserId(Integer userId, Integer price);

}
