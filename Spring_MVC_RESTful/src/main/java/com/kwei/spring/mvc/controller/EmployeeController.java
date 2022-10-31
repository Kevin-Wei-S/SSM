package com.kwei.spring.mvc.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.kwei.spring.mvc.dao.EmployeeDao;
import com.kwei.spring.mvc.pojo.Employee;
/**
 * 
 * Date: 2022年9月1日下午4:35:05
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *
 *	查詢所有的員工訊息 - /employee (get)
 *	跳轉到添加頁面 - /to/add (get)
 *	新增員工訊息 - /employee (post)
 *	跳轉到修改頁面 - /employee/1001 (get)
 *	修改員工訊息 - /employee  (put)
 *	刪除員工訊息 - /employee/1001 (delete)
 *
 */
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	// 員工一覽表
	@GetMapping("/employee")
	public String getAllEmps(Model model) {
		// 獲取員工訊息
		Collection<Employee> emps = employeeDao.getAllEmps();
		// 將所有的員工訊息在請求域共享
		model.addAttribute("emps", emps);
		// 跳轉到列表頁面
		return "employee_list";
	}
	
//	// 根據id查詢員工訊息
//	@GetMapping("/employee/{id}")
//	public String getEmpById(@PathVariable("id") Integer id) {
//		Employee emp = employeeDao.getEmpById(id);
//		System.out.println(emp);
//		return "success";
//	}
	
	// 跳轉至新增頁面
	@GetMapping("/employee/add")
	public String pageToAdd() {
		return "employee_add";
	}

	// 新增員工訊息
	@PostMapping("/employee")
	public String insertEmp(Employee emp) {
		employeeDao.saveEmp(emp);
		return "redirect:/employee";
	}
	
	// 跳轉到修改頁面
	@GetMapping("/employee/update/{id}")
	public String pageToUpdate(@PathVariable("id") Integer id, Model model) {
		Employee emp = employeeDao.getEmpById(id);
		model.addAttribute("emp", emp);
		return "employee_update";
	}
	
	// 修改員工訊息
	@PutMapping("/employee")
	public String updateEmp(Employee emp) {
		employeeDao.saveEmp(emp);
		return "redirect:/employee";
	}
	
	// 確認刪除頁面
	@GetMapping("/employee/delete/{id}")
	public String checkToDeleteEmpById(@PathVariable("id") Integer id) {
		return "employee_delete";
	}
	
	// 刪除員工訊息
	@DeleteMapping("/employee/{id}")
	public String deleteEmpById(@PathVariable("id") Integer id) {
		employeeDao.deleteEmpById(id);
		return "redirect:/employee";
	}
	
	
}
