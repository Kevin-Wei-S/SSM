package com.kwei.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import com.kwei.mybatis.pojo.Department;
import com.kwei.mybatis.pojo.Employee;

public interface DepartmentMapper {

	/**
	 *  �ھ�empId���B(Step.2)�d�߭��u�ι��������T��
	 * @param emp
	 * @return
	 */
	Department getEmployeeAndDepartmentByStepTwo(@Param("deptId")Integer deptId);
	
	/**
	 *  �ھ�deptId�d�߸ӳ������Ҧ����u
	 * @param deptId
	 * @return
	 */
	Department getDepartmentAndEmployeeByDeptId(@Param("deptId") Integer deptId);
	
	/**
	 * 	�ھ�deptId��������γ����Ҧb���u���T��
	 * 	Step.1: ����������T��
	 * @param deptId
	 * @return
	 */
	Department getDeptAndEmpByStepOne(@Param("deptId")Integer deptId);
	
	
	Department getDeptAndEmpByStepOne_One(@Param("deptId")Integer deptId);
	
	
}
