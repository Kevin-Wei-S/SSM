package com.kwei.mybatis.mapper;

import java.util.List;

import com.kwei.mybatis.pojo.User;

/**
 * 
 * Date: 2022�~8��9��U��4:16:06
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *
 */
public interface UserMapper {
	
	/**
	 * 	�K�[�Τ�T��
	 * @return
	 */
	int insertUser();
	
	/**
	 *	�ק�Τ�T�� 
	 * @return
	 */
	void updateUser();
	
	/**
	 * 	�R���Τ�T��
	 * @return
	 */
	int deleteUser();
	
	/**
	 *  �ھ�Id�d�ߥΤ�T��
	 * @return
	 */
	User getUserById();
	
	/**
	 * 	�d�ߩҦ����Τ�T��
	 * @return
	 */
	List<User> getAllUser();
	
}
