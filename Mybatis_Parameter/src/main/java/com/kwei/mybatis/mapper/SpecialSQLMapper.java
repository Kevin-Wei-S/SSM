package com.kwei.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kwei.mybatis.pojo.User;

public interface SpecialSQLMapper {

	/**
	 *  根據模糊查詢獲取用戶訊息
	 * @param likeStr
	 * @return
	 */
	List<User> getUserByLike(@Param("likeStr")String likeStr);
	
	/**
	 *  批量刪除
	 * @param ids
	 */
	void deleteMoreUser(@Param("ids")String ids);
	
	/**
	 * 	動態設置表名, 查詢當前表名所有用戶訊息.
	 * @param tableName
	 * @return
	 */
	List<User> getUserList(@Param("tableName")String tableName);
	
	/**
	 *  添加用戶訊息, 並獲取自增的主鍵.
	 * @param user
	 */
	void insertUser(User user);
	
}
