package com.kwei.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.kwei.mybatis.mapper.DepartmentMapper;
import com.kwei.mybatis.mapper.EmployeeMapper;
import com.kwei.mybatis.pojo.Department;
import com.kwei.mybatis.pojo.Employee;
import com.kwei.mybatis.utils.SqlSessionUtil;

public class ResultMapTest {

	@Test
	public void testGetDeptAndEmpBySteps() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		DepartmentMapper mapper = ss.getMapper(DepartmentMapper.class);
		Department dept = mapper.getDeptAndEmpByStepOne(4);
		System.out.println(dept.getDeptName());
		
	}
	
	
	@Test
	public void testGetDepartmentAndEmployeeByDeptId() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		DepartmentMapper mapper = ss.getMapper(DepartmentMapper.class);
		Department dept = mapper.getDepartmentAndEmployeeByDeptId(4);
		System.out.println(dept);
		
	}
	
	@Test
	public void testGetEmployeeAndDepartmentBySteps() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		EmployeeMapper mapper = ss.getMapper(EmployeeMapper.class);
		Employee emp = mapper.getEmployeeAndDepartmentByStepOne(3);
		System.out.println(emp.getEmpName());
		
	}
	
	@Test
	public void testGetEmployeeAndDepartmentByEmpId() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		EmployeeMapper mapper = ss.getMapper(EmployeeMapper.class);
		Employee employee = mapper.getEmployeeAndDepartmentByEmpId(3);
		System.out.println(employee);
		
	}
	
	@Test
	public void testGetEmployeeByEmpId() {
		
		SqlSession ss = SqlSessionUtil.getSqlSession();
		EmployeeMapper mapper = ss.getMapper(EmployeeMapper.class);
		Employee employee = mapper.getEmployeeAndDepartmentByEmpId(3);
		System.out.println(employee);
		
	}
	
	
}
