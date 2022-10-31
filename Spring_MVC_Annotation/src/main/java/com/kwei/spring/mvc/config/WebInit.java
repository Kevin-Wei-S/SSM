package com.kwei.spring.mvc.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * Date: 2022年9月6日下午4:12:59
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description: 代替web.xml
 *	
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	// 設置一個配置類代替	Spring的配置文件
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {SpringConfig.class};
	}

	// 設置一個配置類代替SpringMVC的配置文件
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {WebConfig.class};
	}

	// 設置SprnigMVC的前端控制器DispatcherServlet的url-pattern
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

	// 設置當前的過濾器
	@Override
	protected Filter[] getServletFilters() {
		// 創建編碼過濾器
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		// 創建處理請求方式的過濾器
		HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
		return new Filter[] {characterEncodingFilter, hiddenHttpMethodFilter};
	}

	

	
	
}
