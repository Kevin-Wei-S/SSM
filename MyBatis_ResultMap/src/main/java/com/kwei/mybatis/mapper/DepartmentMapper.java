package com.kwei.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import com.kwei.mybatis.pojo.Department;
import com.kwei.mybatis.pojo.Employee;

public interface DepartmentMapper {

	/**
	 *  根據empId分步(Step.2)查詢員工及對應部門訊息
	 * @param emp
	 * @return
	 */
	Department getEmployeeAndDepartmentByStepTwo(@Param("deptId")Integer deptId);
	
	/**
	 *  根據deptId查詢該部門的所有員工
	 * @param deptId
	 * @return
	 */
	Department getDepartmentAndEmployeeByDeptId(@Param("deptId") Integer deptId);
	
	/**
	 * 	根據deptId獲取部門及部門所在員工的訊息
	 * 	Step.1: 先獲取部門訊息
	 * @param deptId
	 * @return
	 */
	Department getDeptAndEmpByStepOne(@Param("deptId")Integer deptId);
	
	
	Department getDeptAndEmpByStepOne_One(@Param("deptId")Integer deptId);
	
	
}
