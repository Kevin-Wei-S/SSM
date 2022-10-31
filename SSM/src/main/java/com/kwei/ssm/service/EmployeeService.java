package com.kwei.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kwei.ssm.pojo.Employee;

public interface EmployeeService {

	// ����Ҧ����u��T
	List<Employee> getAllEmployees();
	// �s�W���u
	void addEmployee(Employee employee);
	// �ھ�id�d�߭��u��T
	Employee getEmployeeById(@Param("empId") Integer empId);
	// ��s���u��T
	void updateEmployee(Employee employee);
	// �������u�T��
	void deleteEmployeeById(@Param("empId")Integer empId);
	
}
