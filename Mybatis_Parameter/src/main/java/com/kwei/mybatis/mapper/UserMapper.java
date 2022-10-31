package com.kwei.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kwei.mybatis.pojo.User;
/**
 * 
 * Date: 2022�~8��11��W��11:26:42
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 * 
 * MyBatis����Ѽƪ���ؤ覡:
 * 		1. #{ } - ���P����Ž��
 * 		2. ${ } - ���P�r�Ŧ����(�ݤ�ʥ[��޸�)  
 *  
 *  1. �Ymapper���f��k���ѼƬ���Ӫ��r���q����
 *     ���ɥi�q�L #{} �� ${} �H���N�����e(����)�Ψ����
 *
 *	2. �Ymapper���f����k�ѼƬ��h�Ӧr���q����
 *	   ����MyBatis�|�N�ѼƩ�bmap���X��, �H��ؤ覡�Ӧs�x�ƾ�:
 *			x: (argN, ���) �B N >= 0
 *				�Ҧp: arg0, arg1, arg2, arg3, arg4, arg5, ...
 *			y: (paramN, ���) �B N > 0
 *				�Ҧp:  param1, param2, param3, param4, param5, param6, ...
 *
 *	3. �Ymapper���f��k�ѼƬ��@��map���X�������Ѽ�
 *	   �p�W�u�n�q�L#{}�M${}�X��map���X����, �N�i�H����۹�������, �@�w�n�`�N${}, �ݥ[�@���޸�.
 *
 *	4. �Ymapper���f��k���ѼƬ��������������Ѽ�(pojo)
 *	   �u�ݭn�q�L#{}�M${}�X�ݹ����������ݩʦW, �N�i�H����۹������ݩʭ�, ���`�N${}����޸����D.
 *
 *	5. �i�H�bmapper���f��k���ѼƤW�[�W����@Param(value = ""), 
 *     MyBatis�N�o�ǰѼƩ�JMap��, �H��ؤ覡�i��s�x
 *     	 x. �H@Param���Ѫ�value�ݩʭȬ���, �H�ѼƬ���.
 *	   	 y. �Hparam1�Bparam2�Bparam3��...����, �H�ѼƬ���.
 *		
 */
public interface UserMapper {
	
	/**
	 *  ���ҵn�J(�ϥ�@Param)
	 * @param username
	 * @param password
	 * @return
	 */
	User checkLoginByParam(@Param("username")String username, @Param("password")String password);
	//@Param(value = "username") == @Param("username")
	
	/**
	 *  �K�[�Τ�T��
	 * @param user
	 */
	void insertUser(User user);
	
	/**
	 *  �Τ�n�J���� (�ϥΦ۩w�qmap)
	 * @param map
	 * @return
	 */
	User checkLoginByMap(Map<String,Object> map);
	
	/**
	 *  �Τ�n�J����
	 * @param username
	 * @param password
	 * @return
	 */
	User checkLogin(String username, String password);
	
	/**
	 * 	�ھڥΤ�W�d�ߥΤ�T��
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);
	
	/**
	 *  �Τ�T���@����
	 * @return
	 */
	List<User> getAllUsers();
	
}
