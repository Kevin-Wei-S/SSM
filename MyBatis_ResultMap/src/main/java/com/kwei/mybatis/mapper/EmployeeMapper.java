package com.kwei.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kwei.mybatis.pojo.Employee;

public interface EmployeeMapper {

	/**
	 *  �ھ�empId�d�߭��u�T��
	 * @param empId
	 * @return
	 */
	Employee getEmployeeByEmpId(@Param("empId")Integer empId);
	
	/**
	 *  �ھ�empId�d�߭��u�ι��������T��
	 * @param empId
	 * @return
	 */
	Employee getEmployeeAndDepartmentByEmpId(@Param("empId") Integer empId);
	
	/**
	 * 	�ھ�empId���B(Step.1)�d�߭��u�ι��������T��
	 * @param empId
	 * @return
	 */
	Employee getEmployeeAndDepartmentByStepOne(@Param("empId")Integer empId);
	
	/**
	 * 	�ڪ���k
	 *  �ھ�deptId�d�߳����γ������ݭ��u
	 *  Step.2: �ھ�deptId�d�ߩ��ݭ��u
	 * @param deptId
	 * @return
	 */
	Employee getDeptAndEmpByStepTwo(@Param("deptId")Integer deptId);
	
	/**
	 * 	�Ѯv����k
	 */
	List<Employee> getDeptAndEmpByStepTwoByTeacher(@Param("deptId")Integer deptId);
	
}
