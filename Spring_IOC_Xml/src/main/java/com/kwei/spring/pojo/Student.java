package com.kwei.spring.pojo;

import java.util.Arrays;
import java.util.Map;

public class Student extends Creature implements Person {

	private Integer sId;
	private String sName;
	private Integer age;
	private String gender;
	private Double score;
	private String[] hobby;
	private Map<String,Professor> professorMap;
	private Clazz clazz;
	
	
	public Student() {
		super();
	}

	public Student(Integer sId, String sName, Double score) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.score = score;
	}
	
	public Student(Integer sId, String sName, Integer age) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.age = age;
	}

	public Student(Integer sId, String sName, Integer age, String gender) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.age = age;
		this.gender = gender;
	}

	public Student(Integer sId, String sName, Integer age, String gender, Double score) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.age = age;
		this.gender = gender;
		this.score = score;
	}

	public Student(Integer sId, String sName, Integer age, String gender, Double score, Clazz clazz) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.age = age;
		this.gender = gender;
		this.score = score;
		this.clazz = clazz;
	}

	public Student(Integer sId, String sName, Integer age, String gender, Double score, String[] hobby, Clazz clazz) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.age = age;
		this.gender = gender;
		this.score = score;
		this.hobby = hobby;
		this.clazz = clazz;
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
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

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public Map<String, Professor> getProfessorMap() {
		return professorMap;
	}

	public void setProfessorMap(Map<String, Professor> professorMap) {
		this.professorMap = professorMap;
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", age=" + age + ", gender=" + gender + ", score=" + score
				+ ", hobby=" + Arrays.toString(hobby) + ", professorMap=" + professorMap + ", clazz=" + clazz + "]";
	}
	
}
