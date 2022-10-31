package com.kwei.spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kwei.spring.dao.BookDao;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer getPriceByBookId(Integer bookId) {
		String sql = "SELECT price FROM ssm.t_book WHERE book_id = ?";
		Integer price = jdbcTemplate.queryForObject(sql, Integer.class, bookId);
		return price;
	}

	@Override
	public void updateStockByBookId(Integer bookId) {
		String sql = "UPDATE ssm.t_book SET stock = stock - 1 WHERE book_id = ?";
		jdbcTemplate.update(sql, bookId);
	}

	@Override
	public void updateBalanceByUserId(Integer userId, Integer price) {
		String sql = "UPDATE ssm.t_user SET balance = balance - ? WHERE user_id = ?";
		jdbcTemplate.update(sql, price, userId);
	}
	
}
