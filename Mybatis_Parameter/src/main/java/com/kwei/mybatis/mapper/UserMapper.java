package com.kwei.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kwei.mybatis.pojo.User;
/**
 * 
 * Date: 2022年8月11日上午11:26:42
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 * 
 * MyBatis獲取參數的兩種方式:
 * 		1. #{ } - 等同佔位符賦值
 * 		2. ${ } - 等同字符串拼接(需手動加單引號)  
 *  
 *  1. 若mapper接口方法的參數為單個的字面量類型
 *     此時可通過 #{} 或 ${} 以任意的內容(型參)或取實參
 *
 *	2. 若mapper接口的方法參數為多個字面量類型
 *	   此時MyBatis會將參數放在map集合中, 以兩種方式來存儲數據:
 *			x: (argN, 實參) 且 N >= 0
 *				例如: arg0, arg1, arg2, arg3, arg4, arg5, ...
 *			y: (paramN, 實參) 且 N > 0
 *				例如:  param1, param2, param3, param4, param5, param6, ...
 *
 *	3. 若mapper接口方法參數為一個map集合類型的參數
 *	   如上只要通過#{}和${}訪問map集合的鍵, 就可以獲取相對應的值, 一定要注意${}, 需加一對單引號.
 *
 *	4. 若mapper接口方法的參數為實體類類型的參數(pojo)
 *	   只需要通過#{}和${}訪問實體類中的屬性名, 就可以獲取相對應的屬性值, 須注意${}的單引號問題.
 *
 *	5. 可以在mapper接口方法的參數上加上註解@Param(value = ""), 
 *     MyBatis將這些參數放入Map中, 以兩種方式進行存儲
 *     	 x. 以@Param註解的value屬性值為鍵, 以參數為值.
 *	   	 y. 以param1、param2、param3等...為鍵, 以參數為值.
 *		
 */
public interface UserMapper {
	
	/**
	 *  驗證登入(使用@Param)
	 * @param username
	 * @param password
	 * @return
	 */
	User checkLoginByParam(@Param("username")String username, @Param("password")String password);
	//@Param(value = "username") == @Param("username")
	
	/**
	 *  添加用戶訊息
	 * @param user
	 */
	void insertUser(User user);
	
	/**
	 *  用戶登入驗證 (使用自定義map)
	 * @param map
	 * @return
	 */
	User checkLoginByMap(Map<String,Object> map);
	
	/**
	 *  用戶登入驗證
	 * @param username
	 * @param password
	 * @return
	 */
	User checkLogin(String username, String password);
	
	/**
	 * 	根據用戶名查詢用戶訊息
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);
	
	/**
	 *  用戶訊息一覽表
	 * @return
	 */
	List<User> getAllUsers();
	
}
