package com.kwei.spring.pojo;

public class Teacher extends Creature implements Person {
	
	private Integer id;
	private String name;
	private String major;
	
	public Teacher() {
		super();
	}

	public Teacher(Integer id, String name, String major) {
		super();
		this.id = id;
		this.name = name;
		this.major = major;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", major=" + major + "]";
	}
	
}
