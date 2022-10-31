package com.kwei.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kwei.ssm.mapper.EmployeeMapper;
import com.kwei.ssm.pojo.Employee;
import com.kwei.ssm.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Employee> getAllEmployees(){
		return employeeMapper.getAllEmployees();
	}
	
	public void addEmployee(Employee employee) {
		employeeMapper.addEmployee(employee);
	}
	
	public Employee getEmployeeById(Integer empId) {
		return employeeMapper.getEmployeeById(empId);
	}
	
	public void updateEmployee(Employee employee) {
		employeeMapper.updateEmployee(employee);
	}
	
	public void deleteEmployeeById(Integer empId) {
		employeeMapper.deleteEmployeeById(empId);
	}
	
}
