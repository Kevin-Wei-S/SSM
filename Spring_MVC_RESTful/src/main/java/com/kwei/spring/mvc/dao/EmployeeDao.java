package com.kwei.spring.mvc.dao;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kwei.spring.mvc.pojo.Employee;

@Repository
public class EmployeeDao {

	private static Map<Integer,Employee> employees = new LinkedHashMap<Integer,Employee>();
	
	static {
		employees.put(1001, new Employee(1001, "Jax", "Jax@gmail.com", 1));
		employees.put(2002, new Employee(2002, "Lux", "Lux@gmail.com", 0));
		employees.put(3003, new Employee(3003, "Fizz", "Fizz@gmail.com", 2));
		employees.put(4004, new Employee(4004, "Yasuo", "Yasuo@gmail.com", 1));
		employees.put(5005, new Employee(5005, "Jinx", "Jinx@gmail.com", 0));
		employees.put(6006, new Employee(6006, "GP", "GP@gmail.com", 1));
	}
	
	private static Integer initId = 7007;
	
	public void saveEmp(Employee employee) {
		if(employee.getId() == null) {
			employee.setId(initId);
			initId+=1001;
		}
		employees.put(employee.getId(), employee);
	}
	
	public Collection<Employee> getAllEmps(){
		return employees.values();
	}
	
	public Employee getEmpById(Integer id) {
		return employees.get(id);
	}
	
	public void deleteEmpById(Integer id) {
		if(employees.containsKey(id)) {
			employees.remove(id);
		}
	}

	
}
