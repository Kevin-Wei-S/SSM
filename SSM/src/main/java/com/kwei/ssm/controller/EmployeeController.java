package com.kwei.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kwei.ssm.pojo.Employee;
import com.kwei.ssm.service.EmployeeService;

@Transactional
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	/**
	 *  員工分頁表
	 * @param pageNum
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/employee/page/{pageNum}", method=RequestMethod.GET)
	public String getAllEmployees(@PathVariable("pageNum") Integer pageNum,
																Model model){
		Integer pageSize = 4;
		Integer navigatePages = 5;
		PageInfo<Employee> pageInfo = pageInfo(pageNum, pageSize, navigatePages);
		
		if(pageNum == null || pageNum < 1) {
			pageInfo = pageInfo(1, pageSize, navigatePages);
		}
		int pages = pageInfo.getPages();
		if(pageNum > pages) {
			pageInfo = pageInfo(pages, pageSize, navigatePages);
		}
		
		model.addAttribute("pageInfo", pageInfo);
		return "employee_list";
	}

	/**
	 * 	新增員工頁面
	 * @return
	 */
	@GetMapping("/employee/page/add")
	public String forwardToAddEmployee() {
		return "employee_add";
	}
	
	/**
	 *  新增員工後重定向回員工分頁
	 * @param employee
	 * @return
	 */
	@PostMapping("/employee/add")
	public String addEmployee(Employee employee) {
		employeeService.addEmployee(employee);
		Integer pages = pageInfo(1,4,5).getPages();
		return "redirect:/employee/page/" + pages;
	}
	
	/**
	 *  員工更新個人資訊頁面
	 * @param empId
	 * @param pageNum
	 * @param model
	 * @return
	 */
	@GetMapping("/employee/page/update/{empId}/{pageNum}")
	public String forwardToUpdateEmployee(@PathVariable("empId") Integer empId,
			@PathVariable("pageNum") Integer pageNum, Model model) {
		
		Employee employee = employeeService.getEmployeeById(empId);
		model.addAttribute("empId", empId);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("employee", employee);
			
		return "employee_update"; 
	}
	
	/**
	 * 	更新員工資訊後重定向回員工分頁表
	 * @return
	 */
	@PutMapping("/employee/update")
	public String updateEmployee(Employee employee, Integer pageNum) {
		
		employeeService.updateEmployee(employee);
		return "redirect:/employee/page/" + pageNum;
		
	}
	
	/**
	 *  根據id移除員工訊息
	 * @param empId
	 * @param pageNum
	 * @return
	 */
	@DeleteMapping("/employee/delete/{empId}")
	public String deleteEmployeeById(@PathVariable("empId") Integer empId, 
			Integer pageNum) {
		
		employeeService.deleteEmployeeById(empId);
		return "redirect:/employee/page/" + pageNum;
		
	}
	
	/**
	 * 分頁攔截器
	 * @param pageNum
	 * @param pageSize
	 * @param navigatePages
	 * @return
	 */
	private PageInfo<Employee> pageInfo(Integer pageNum, Integer pageSize, 
										Integer navigatePages) {
		Page<Object> page = PageHelper.startPage(pageNum, pageSize);
		List<Employee> list = employeeService.getAllEmployees();
		PageInfo<Employee> pageInfo = new PageInfo<>(list, navigatePages);
		return pageInfo;
	}
	
	// 測試異常解析器
	@RequestMapping("/test/exception")
	public String testException() {
		System.out.println(100/0);
		return "success";
	}
	
}
