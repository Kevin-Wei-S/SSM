package com.kwei.ssm.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kwei.ssm.controller.EmployeeController;
import com.kwei.ssm.mapper.EmployeeMapper;
import com.kwei.ssm.pojo.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml", "classpath:springmvc.xml"})
public class TestSSM {
	
	@Autowired
	private EmployeeController employeeController;
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Test
	public void testEmployeeController() {
		//employeeController.getAllEmployees().forEach(System.out::println);
	}
	
	@Test
	public void testPage() {
		Page<Object> page = PageHelper.startPage(2, 2);
		List<Employee> list = employeeMapper.getAllEmployees();
		PageInfo<Employee> pageInfo = new PageInfo<>(list, 5);
		System.out.println(pageInfo);
		//System.out.println(Arrays.toString(pageInfo.getNavigatepageNums()));
	}
	
}
