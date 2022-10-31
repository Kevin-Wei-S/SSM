package com.kwei.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.kwei.mybatis.pojo.User;

/**
 *	w. �Ysql�y�y�d�ߪ����G���h����, �@�w����H�����������@����k����^������.
 *	   �_�h�|�ߥX���`(TooManyResultsException)
 *	
 *	s. �Ysql�y�y�d�ߪ����G���@����, �i�H�ϥ�List<����������>�@����k����^������.
 *	
 *	 
 * Date: 2022�~8��15��U��12:35:28
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *
 */

public interface SelectMapper {

	/**
	 *  �ھ�id����Τ�T��
	 * @param id
	 * @return
	 */
	User getUserById(@Param("id")int id);
	
	/**
	 *  ����Ҧ��Τ�T��
	 * @return
	 */
	List<User> getAllUsers();
	
	/**
	 *  �ھڥΤ�W����Τ�T��
	 * @param username
	 * @return
	 */
	List<User> getUserByUsername(@Param("username")String username);
	
	/**
	 *  �ھ�id�d�ߥΤ᪺�~��
	 * @param id
	 * @return
	 */
	Integer getAgeById(@Param("id")Integer id);
	
	/**
	 *  ����`����
	 * @return
	 */
	Integer getCount();
	
	/**
	 *  �ھ�id����Τ�T��, �ñN�T���HMap�覡�s�x(�D������������Map).
	 * @param id
	 * @return
	 */
	Map<String,Object> getUserByIdToMap(@Param("id") Integer id);
	
	/**
	 *  ����Ҧ��Τ᪺�T��, �ñN�T���HMap�覡�s�x(�D������������Map).
	 * @return
	 */
	// M1:
//	List<Map<String,Object>> getAllUsersToMap();
	
	// M2:
	@MapKey("id")
	Map<String,Object> getAllUsersToMap();
	
}
