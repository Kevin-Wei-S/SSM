package com.kwei.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import com.kwei.mybatis.pojo.Emp;

public interface CacheMapper {
	
	/**
	 * 根據empId獲取員工資訊
	 * @param empId
	 * @return
	 */
	Emp getEmpByEmpId(@Param("empId")Integer empId);
	
	/**
	 *  新增一筆員工訊息
	 * @param emp
	 */
	void insertEmp(Emp emp);
	
}
