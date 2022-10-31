package com.kwei.spring.factory;

import org.springframework.beans.factory.FactoryBean;

import com.kwei.spring.pojo.User;

/*
 * FactoryBean�O�@�ӱ��f, �ݭn�@�ӹ�{��.
 * 		�䤤���T�Ӥ�k:
 * 			1. getObject(): ��^�@�ӹ�H�浹IOC�e���޲z
 * 			2. getObjectType(): ��^��H�Ҵ��Ѫ�����
 * 			3. isSingleton(): �Ҵ��Ѫ���H�O�_�����
 * 		���FactoryBean���f����{���t�m���@��Bean��, �|�եι�{����H����getObject(),
 * 		�ñN��k������^�ȧ@��IOC�e�����޲z����H.
 * 
 * 
 */
public class UserFactoryBean implements FactoryBean<User> {

	@Override
	public User getObject() throws Exception {
		return new User();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
	
}
