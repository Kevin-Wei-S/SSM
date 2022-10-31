package com.kwei.spring.pojo;

import java.util.List;

public class Clazz {

	private String cId;
	private String cName;
	private List<Student> students;
	
	public Clazz() {
		super();
	}

	public Clazz(String cId, String cName) {
		super();
		this.cId = cId;
		this.cName = cName;
	}

	public Clazz(String cId, String cName, List<Student> students) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.students = students;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Clazz [cId=" + cId + ", cName=" + cName + ", students=" + students + "]";
	}
	
	
}
