package com.kwei.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kwei.mybatis.pojo.Emp;

/**
 * 
 * Date: 2022年8月17日下午1:14:41
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *
 */
public interface DynamicSQLMapper {
	/**
	 * 	根據條件查詢員工的訊息
	 * 
	 * @param emp
	 * @return
	 */
	List<Emp> getEmpByConditions(Emp emp); 
	
	/**
	 *  根據choose、when、otherwise標籤組, 來查詢員工訊息.
	 * @param emp
	 * @return
	 */
	List<Emp> getEmpByChoose(Emp emp);
	
	/**
	 * 	批量添加: 使用foreach標籤添加多位員工訊息
	 * 
	 * @param emps
	 */
	void insertMoreEmps(@Param("emps") List<Emp> emps);
	
	/**
	 *  批量刪除: 使用foreach標籤刪除多位員工訊息
	 * @param emps
	 */
	void deleteMoreEmpsByEmpIds(@Param("empIds") Integer[] empIds);
	
	
}
