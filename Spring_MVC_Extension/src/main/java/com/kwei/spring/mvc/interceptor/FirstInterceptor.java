package com.kwei.spring.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * Date: 2022�~9��6��W��11:23:43
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *
 *	�d�I�����T�Ӥ�k:
 *		preHandle(): �b�����k�B�z�ШD�e����, ���^�Ȭ�Boolean����,
 *					 false���d�I; true�����;
 *		postHandle(): �b�����k�B�z�ШD�����, �L��^��. 
 *		afterCompletion(): �b�����k�B�z�ШD��, 
 *						   �BthymeleafViewResolver��V�����ϫ����.
 *	
 *	�h���d�I�������涶�ǩM�bspringmvc.xml�t�m�����Ǧ���
 *		preHandle(): ���Ӱt�m���ǰ���
 *		postHandle(): ���Ӱt�m���f���ǰ���
 *		afterCompletion(): ���Ӱt�m���϶��ǰ���
 *	�Y�d�I�������S�w�d�I��preHandle����^�Ȭ�false
 *		�S�w�d�I��preHandle����^�Ȭ�false, �h���d�I�����e���d�I�����|����preHandle().
 *		�Ҧ����d�I����postHandle()�Ҥ�����
 *		�S�w�d�I��preHandle()��^false���e���d�I���ҷ|����afterCompletion()
 */
@Component
public class FirstInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("FirstInterceptor: preHandle");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("FirstInterceptor: postHandler");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("FirstHandler: afterCompletion");
	}

	
	
}
