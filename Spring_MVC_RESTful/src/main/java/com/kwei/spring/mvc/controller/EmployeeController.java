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
 * Date: 2022�~9��1��U��4:35:05
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *
 *	�d�ߩҦ������u�T�� - /employee (get)
 *	�����K�[���� - /to/add (get)
 *	�s�W���u�T�� - /employee (post)
 *	�����קﭶ�� - /employee/1001 (get)
 *	�ק���u�T�� - /employee  (put)
 *	�R�����u�T�� - /employee/1001 (delete)
 *
 */
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	// ���u�@����
	@GetMapping("/employee")
	public String getAllEmps(Model model) {
		// ������u�T��
		Collection<Employee> emps = employeeDao.getAllEmps();
		// �N�Ҧ������u�T���b�ШD��@��
		model.addAttribute("emps", emps);
		// �����C����
		return "employee_list";
	}
	
//	// �ھ�id�d�߭��u�T��
//	@GetMapping("/employee/{id}")
//	public String getEmpById(@PathVariable("id") Integer id) {
//		Employee emp = employeeDao.getEmpById(id);
//		System.out.println(emp);
//		return "success";
//	}
	
	// ����ܷs�W����
	@GetMapping("/employee/add")
	public String pageToAdd() {
		return "employee_add";
	}

	// �s�W���u�T��
	@PostMapping("/employee")
	public String insertEmp(Employee emp) {
		employeeDao.saveEmp(emp);
		return "redirect:/employee";
	}
	
	// �����קﭶ��
	@GetMapping("/employee/update/{id}")
	public String pageToUpdate(@PathVariable("id") Integer id, Model model) {
		Employee emp = employeeDao.getEmpById(id);
		model.addAttribute("emp", emp);
		return "employee_update";
	}
	
	// �ק���u�T��
	@PutMapping("/employee")
	public String updateEmp(Employee emp) {
		employeeDao.saveEmp(emp);
		return "redirect:/employee";
	}
	
	// �T�{�R������
	@GetMapping("/employee/delete/{id}")
	public String checkToDeleteEmpById(@PathVariable("id") Integer id) {
		return "employee_delete";
	}
	
	// �R�����u�T��
	@DeleteMapping("/employee/{id}")
	public String deleteEmpById(@PathVariable("id") Integer id) {
		employeeDao.deleteEmpById(id);
		return "redirect:/employee";
	}
	
	
}
