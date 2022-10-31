package com.kwei.mybatis.pojo;

public class Emp {
    private Integer empId;

    private String empName;

    private Integer age;

    private String gender;

    private Integer deptId;
    
    public Emp() {
		super();
	}

	public Emp(Integer empId, String empName, Integer age, String gender, Integer deptId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.age = age;
		this.gender = gender;
		this.deptId = deptId;
	}

	public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
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
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", age=" + age + ", gender=" + gender + ", deptId="
				+ deptId + "]";
	}
    
}