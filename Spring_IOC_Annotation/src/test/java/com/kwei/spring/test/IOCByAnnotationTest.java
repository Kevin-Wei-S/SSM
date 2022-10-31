package com.kwei.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kwei.spring.controller.UserController;
import com.kwei.spring.dao.UserDao;
import com.kwei.spring.dao.impl.UserDaoImpl;
import com.kwei.spring.pojo.IncludeService;
import com.kwei.spring.service.UserService;
import com.kwei.spring.service.impl.UserServiceImpl;

public class IOCByAnnotationTest {
	
	/**
	 * 	@Component: 將類標示為普通組件(如非下述三種, 基本會採用此通用標籤)
	 * 	@Controller: 將類標示為控制層組件
	 *  @Service: 將類標示為業務層組件
	 * 	@Repository: 將類標示為持久層組件
	 * 
	 *  通過註解+掃描所配置的Bean的id, 默認值為類的小駝峰, 即類名的首字母為小寫.
	 *  可以通過標示組件的註解的value屬性值, 自定義Bean的id名.
	 *  
	 *  @Autowired: 實現自動裝配功能的註解
	 *   1. @Autowired 註解能標示的位置
	 *  	x. 標示在成員變量上, 此時無須設置成員變量的setter方法
	 *  	y. 標示在setter方法上
	 * 		z. 標示在有參構造器上
	 *   2. @Autowired 註解的原理:
	 *  	w. 默認通過byType的方式, 在IOC容器中通過類型匹配目標Bean後, 為屬性賦值.
	 *  	s. 若有多個類型匹配的Bean, 會自動轉換為byName的方式, 獲取匹配的Bean賦值.
	 *  	x. 根據byType及byName皆無法自動裝配:
	 *  			q. 無匹配類型: 則會報錯NullPointerException(這裡因為屬性值為null)
	 *  			a. 多匹配類型無匹配id: 報錯NoUniqueBeanDefinitionException
	 *  	e. 此時可以在要賦值的屬性上, 添加一個註解@Qualifier(), value值為指定id.
	 *  	d. @Autowired(required=false)
	 *  			true(預設): 強制自動裝配, 不滿足即報錯.
				 	false: 自動裝配不滿足, 則用預設值. 
	 */
	
	
	@Test
	public void testIOCByAnnotationAboutAutowired() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_ioc_annotation.xml");
		UserController userController = ioc.getBean(UserController.class);
		userController.saveUser();
		
	}
	
	@Test
	public void testIOCByAnnotationAboutId() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_ioc_annotation.xml");
//		UserController userController = ioc.getBean("controller", UserController.class);
//		System.out.println(userController);
		
		UserService userService = ioc.getBean("userServiceImpl", UserService.class);
		System.out.println(userService);
		
		UserDao userDao = ioc.getBean("userDaoImpl", UserDao.class);
		System.out.println(userDao);
		
	}
	
	@Test
	public void testIOCByAnnotation() {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring_ioc_annotation.xml");
		UserController userController = ioc.getBean(UserController.class);
		System.out.println(userController);
		
		UserService userService = ioc.getBean(UserService.class);
		System.out.println(userService);
		
		UserDao userDao = ioc.getBean(UserDao.class);
		System.out.println(userDao);
		
//		IncludeService includeService = ioc.getBean(IncludeService.class);
//		System.out.println(includeService);
	}
	
}
