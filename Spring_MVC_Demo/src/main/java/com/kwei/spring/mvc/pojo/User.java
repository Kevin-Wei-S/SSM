package com.kwei.spring.mvc.pojo;

import java.io.Serializable;

public class User implements Serializable{

	private final static long serialVersionUID = 43294234793293242L;
	
	private String username;
	private String password;
	private Integer age;
	private String gender;
	private String address;
	private String phone;
	private String email;
	
	public User() {
		super();
	}

	public User(String username, String password, Integer age, String gender, String address, String phone,
			String email) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + ", phone=" + phone + ", email=" + email + "]";
	}
	
	
}
