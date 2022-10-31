package com.kwei.spring.factory;

import org.springframework.beans.factory.FactoryBean;

import com.kwei.spring.pojo.User;

/*
 * FactoryBean是一個接口, 需要一個實現類.
 * 		其中有三個方法:
 * 			1. getObject(): 返回一個對象交給IOC容器管理
 * 			2. getObjectType(): 返回對象所提供的類型
 * 			3. isSingleton(): 所提供的對象是否為單例
 * 		當把FactoryBean接口的實現類配置為一個Bean時, 會調用實現類對象中的getObject(),
 * 		並將方法中的返回值作為IOC容器的管理的對象.
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
