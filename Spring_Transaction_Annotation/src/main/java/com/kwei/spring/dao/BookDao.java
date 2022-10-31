package com.kwei.spring.dao;

public interface BookDao {

	/**
	 *  �ھڹϮѪ�id�d�߹Ϯѻ���
	 * @param bookId
	 * @return
	 */
	Integer getPriceByBookId(Integer bookId);

	/**
	 *  �ھڹϮѪ�id��s�ϮѮw�s
	 * @param bookId
	 */
	void updateStockByBookId(Integer bookId);

	/**
	 *  �ھڥΤ᪺id��s�Τ�l�B
	 * @param userId
	 * @param price
	 */
	void updateBalanceByUserId(Integer userId, Integer price);

}
