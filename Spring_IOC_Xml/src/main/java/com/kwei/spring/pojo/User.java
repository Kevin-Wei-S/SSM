package com.kwei.spring.pojo;

public class User {

	private Integer id;
	private String username;
	private String password;
	private	Integer age;
	
	public User() {
		super();
		// 工廠模式 + 反射 (+ 註解)
		System.out.println("Bean-LifeCycle-1: 實例化");
	}
	
	public User(Integer id, String username, String password, Integer age) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		System.out.println("Bean-LifeCycle-2: 依賴注入");
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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + "]";
	}
	
	public void init() {
		System.out.println("Bean-LifeCycle-3: 初始化");
	}
	
	public void destroy() {
		System.out.println("Bean-LifeCycle-4: 結束生命週期");
	}
	
}
