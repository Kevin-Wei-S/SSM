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
	 * 	@Component: �N���Хܬ����q�ե�(�p�D�U�z�T��, �򥻷|�ĥΦ��q�μ���)
	 * 	@Controller: �N���Хܬ�����h�ե�
	 *  @Service: �N���Хܬ��~�ȼh�ե�
	 * 	@Repository: �N���Хܬ����[�h�ե�
	 * 
	 *  �q�L����+���y�Ұt�m��Bean��id, �q�{�Ȭ������p�m�p, �Y���W�����r�����p�g.
	 *  �i�H�q�L�Хܲե󪺵��Ѫ�value�ݩʭ�, �۩w�qBean��id�W.
	 *  
	 *  @Autowired: ��{�۰ʸ˰t�\�઺����
	 *   1. @Autowired ���ѯ�Хܪ���m
	 *  	x. �Хܦb�����ܶq�W, ���ɵL���]�m�����ܶq��setter��k
	 *  	y. �Хܦbsetter��k�W
	 * 		z. �Хܦb���Ѻc�y���W
	 *   2. @Autowired ���Ѫ���z:
	 *  	w. �q�{�q�LbyType���覡, �bIOC�e�����q�L�����ǰt�ؼ�Bean��, ���ݩʽ��.
	 *  	s. �Y���h�������ǰt��Bean, �|�۰��ഫ��byName���覡, ����ǰt��Bean���.
	 *  	x. �ھ�byType��byName�ҵL�k�۰ʸ˰t:
	 *  			q. �L�ǰt����: �h�|����NullPointerException(�o�̦]���ݩʭȬ�null)
	 *  			a. �h�ǰt�����L�ǰtid: ����NoUniqueBeanDefinitionException
	 *  	e. ���ɥi�H�b�n��Ȫ��ݩʤW, �K�[�@�ӵ���@Qualifier(), value�Ȭ����wid.
	 *  	d. @Autowired(required=false)
	 *  			true(�w�]): �j��۰ʸ˰t, �������Y����.
				 	false: �۰ʸ˰t������, �h�ιw�]��. 
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
