package com.kwei.mybatis.mapper;

import java.util.List;

import com.kwei.mybatis.pojo.User;

/**
 * 
 * Date: 2022年8月9日下午4:16:06
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *
 */
public interface UserMapper {
	
	/**
	 * 	添加用戶訊息
	 * @return
	 */
	int insertUser();
	
	/**
	 *	修改用戶訊息 
	 * @return
	 */
	void updateUser();
	
	/**
	 * 	刪除用戶訊息
	 * @return
	 */
	int deleteUser();
	
	/**
	 *  根據Id查詢用戶訊息
	 * @return
	 */
	User getUserById();
	
	/**
	 * 	查詢所有的用戶訊息
	 * @return
	 */
	List<User> getAllUser();
	
}
