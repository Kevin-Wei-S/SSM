package com.kwei.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import com.kwei.mybatis.pojo.Emp;

public interface CacheMapper {
	
	/**
	 * �ھ�empId������u��T
	 * @param empId
	 * @return
	 */
	Emp getEmpByEmpId(@Param("empId")Integer empId);
	
	/**
	 *  �s�W�@�����u�T��
	 * @param emp
	 */
	void insertEmp(Emp emp);
	
}
