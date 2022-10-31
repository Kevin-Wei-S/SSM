package com.kwei.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kwei.mybatis.pojo.Emp;

/**
 * 
 * Date: 2022�~8��17��U��1:14:41
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *
 */
public interface DynamicSQLMapper {
	/**
	 * 	�ھڱ���d�߭��u���T��
	 * 
	 * @param emp
	 * @return
	 */
	List<Emp> getEmpByConditions(Emp emp); 
	
	/**
	 *  �ھ�choose�Bwhen�Botherwise���Ҳ�, �Ӭd�߭��u�T��.
	 * @param emp
	 * @return
	 */
	List<Emp> getEmpByChoose(Emp emp);
	
	/**
	 * 	��q�K�[: �ϥ�foreach���ҲK�[�h����u�T��
	 * 
	 * @param emps
	 */
	void insertMoreEmps(@Param("emps") List<Emp> emps);
	
	/**
	 *  ��q�R��: �ϥ�foreach���ҧR���h����u�T��
	 * @param emps
	 */
	void deleteMoreEmpsByEmpIds(@Param("empIds") Integer[] empIds);
	
	
}
