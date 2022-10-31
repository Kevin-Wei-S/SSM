package com.kwei.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kwei.mybatis.pojo.Employee;

public interface EmployeeMapper {

	/**
	 *  根據empId查詢員工訊息
	 * @param empId
	 * @return
	 */
	Employee getEmployeeByEmpId(@Param("empId")Integer empId);
	
	/**
	 *  根據empId查詢員工及對應部門訊息
	 * @param empId
	 * @return
	 */
	Employee getEmployeeAndDepartmentByEmpId(@Param("empId") Integer empId);
	
	/**
	 * 	根據empId分步(Step.1)查詢員工及對應部門訊息
	 * @param empId
	 * @return
	 */
	Employee getEmployeeAndDepartmentByStepOne(@Param("empId")Integer empId);
	
	/**
	 * 	我的方法
	 *  根據deptId查詢部門及部門所屬員工
	 *  Step.2: 根據deptId查詢所屬員工
	 * @param deptId
	 * @return
	 */
	Employee getDeptAndEmpByStepTwo(@Param("deptId")Integer deptId);
	
	/**
	 * 	老師的方法
	 */
	List<Employee> getDeptAndEmpByStepTwoByTeacher(@Param("deptId")Integer deptId);
	
}
