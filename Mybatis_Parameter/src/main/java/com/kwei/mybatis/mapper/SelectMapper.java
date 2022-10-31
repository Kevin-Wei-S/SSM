package com.kwei.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.kwei.mybatis.pojo.User;

/**
 *	w. 若sql語句查詢的結果為多條時, 一定不能以實體類類型作為方法的返回值類型.
 *	   否則會拋出異常(TooManyResultsException)
 *	
 *	s. 若sql語句查詢的結果為一條時, 可以使用List<實體類類型>作為方法的返回值類型.
 *	
 *	 
 * Date: 2022年8月15日下午12:35:28
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *
 */

public interface SelectMapper {

	/**
	 *  根據id獲取用戶訊息
	 * @param id
	 * @return
	 */
	User getUserById(@Param("id")int id);
	
	/**
	 *  獲取所有用戶訊息
	 * @return
	 */
	List<User> getAllUsers();
	
	/**
	 *  根據用戶名獲取用戶訊息
	 * @param username
	 * @return
	 */
	List<User> getUserByUsername(@Param("username")String username);
	
	/**
	 *  根據id查詢用戶的年齡
	 * @param id
	 * @return
	 */
	Integer getAgeById(@Param("id")Integer id);
	
	/**
	 *  獲取總筆數
	 * @return
	 */
	Integer getCount();
	
	/**
	 *  根據id獲取用戶訊息, 並將訊息以Map方式存儲(非實體類類型的Map).
	 * @param id
	 * @return
	 */
	Map<String,Object> getUserByIdToMap(@Param("id") Integer id);
	
	/**
	 *  獲取所有用戶的訊息, 並將訊息以Map方式存儲(非實體類類型的Map).
	 * @return
	 */
	// M1:
//	List<Map<String,Object>> getAllUsersToMap();
	
	// M2:
	@MapKey("id")
	Map<String,Object> getAllUsersToMap();
	
}
