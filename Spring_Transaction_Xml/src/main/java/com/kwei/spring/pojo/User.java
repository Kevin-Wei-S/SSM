package com.kwei.spring.pojo;

public class User {

	private Integer userId;
	private String username;
	private Integer balance;
	
	public User() {
		super();
	}

	public User(Integer userId, String username, Integer balance) {
		super();
		this.userId = userId;
		this.username = username;
		this.balance = balance;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", balance=" + balance + "]";
	}
	
}
