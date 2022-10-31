package com.kwei.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kwei.ssm.pojo.Employee;

public interface EmployeeService {

	// 獲取所有員工資訊
	List<Employee> getAllEmployees();
	// 新增員工
	void addEmployee(Employee employee);
	// 根據id查詢員工資訊
	Employee getEmployeeById(@Param("empId") Integer empId);
	// 更新員工資訊
	void updateEmployee(Employee employee);
	// 移除員工訊息
	void deleteEmployeeById(@Param("empId")Integer empId);
	
}
