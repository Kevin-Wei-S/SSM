package com.kwei.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kwei.mybatis.pojo.User;

public interface SpecialSQLMapper {

	/**
	 *  �ھڼҽk�d������Τ�T��
	 * @param likeStr
	 * @return
	 */
	List<User> getUserByLike(@Param("likeStr")String likeStr);
	
	/**
	 *  ��q�R��
	 * @param ids
	 */
	void deleteMoreUser(@Param("ids")String ids);
	
	/**
	 * 	�ʺA�]�m��W, �d�߷�e��W�Ҧ��Τ�T��.
	 * @param tableName
	 * @return
	 */
	List<User> getUserList(@Param("tableName")String tableName);
	
	/**
	 *  �K�[�Τ�T��, ������ۼW���D��.
	 * @param user
	 */
	void insertUser(User user);
	
}
