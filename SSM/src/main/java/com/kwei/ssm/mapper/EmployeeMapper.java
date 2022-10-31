package com.kwei.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kwei.ssm.pojo.Employee;

public interface EmployeeMapper {

	List<Employee> getAllEmployees();
	
	void addEmployee(Employee employee);
	
	Employee getEmployeeById(@Param("empId") Integer empId);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployeeById(@Param("empId")Integer empId);
}
