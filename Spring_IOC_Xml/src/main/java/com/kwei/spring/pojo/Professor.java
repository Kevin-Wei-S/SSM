package com.kwei.spring.pojo;

public class Professor {

	private Integer pId;
	private String pName;
	
	public Professor() {
		super();
	}

	public Professor(Integer pId, String pName) {
		super();
		this.pId = pId;
		this.pName = pName;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	@Override
	public String toString() {
		return "Professor [pId=" + pId + ", pName=" + pName + "]";
	}
	
	
}
