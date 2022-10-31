package com.kwei.spring.mvc.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * Date: 2022�~9��6��U��4:12:59
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description: �N��web.xml
 *	
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	// �]�m�@�Ӱt�m���N��	Spring���t�m���
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {SpringConfig.class};
	}

	// �]�m�@�Ӱt�m���N��SpringMVC���t�m���
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {WebConfig.class};
	}

	// �]�mSprnigMVC���e�ݱ��DispatcherServlet��url-pattern
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

	// �]�m��e���L�o��
	@Override
	protected Filter[] getServletFilters() {
		// �Ыؽs�X�L�o��
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		// �ЫسB�z�ШD�覡���L�o��
		HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
		return new Filter[] {characterEncodingFilter, hiddenHttpMethodFilter};
	}

	

	
	
}
