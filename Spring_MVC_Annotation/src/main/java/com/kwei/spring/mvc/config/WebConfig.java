package com.kwei.spring.mvc.config;

import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import com.kwei.spring.mvc.interceptor.FirstInterceptor;
/**
 * 
 * Date: 2022�~9��6��U��4:20:49
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description: �N��SpringMVC���t�m���
 *	���y�ե�B���ϸѪR���B�q�{��servlet�Bmvc�������X�ʡB
 *	���ϱ���B���W�ǸѪR���B�d�I���B���`�ѪR��	
 *
 *
 */

// �Хܬ��@�Ӱt�m��
@Configuration
// ���y�ե�
@ComponentScan("com.kwei.spring.mvc.controller")
// �}��Mvc�������X��
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	// �ϥ��q�{Servlet�B�z�R�A�귽
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// �]�m���ϱ��
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}
	
	// �]�m���W�ǸѪR��
	@Bean // �i�H�N�Х�@Bean��k����^�ȧ@��Bean�B�浹IOC�i��޲z, Bean��id�Y����k�W. 
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
	
	// �]�m�d�I��
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new FirstInterceptor()).
			addPathPatterns("/**").excludePathPatterns("/abc");
	}

	// �t�m���`�ѪR��
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		Properties prop = new Properties();
		prop.setProperty("java.lang.ArithmeticException", "error");
		exceptionResolver.setExceptionMappings(prop);
		exceptionResolver.setExceptionAttribute("ex");
		resolvers.add(exceptionResolver);
	}
	
	// �]�m���ϸѪR��
	@Bean
	public ITemplateResolver templateResolver() {
		
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(webApplicationContext.getServletContext());
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setCharacterEncoding("UTF-8");
		
		return templateResolver;
	}
	
	@Bean
	public TemplateEngine templateEngine(ITemplateResolver templateResolver) {
		
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		return templateEngine;
		
	}
	
	@Bean
	public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		viewResolver.setOrder(1);
		viewResolver.setCharacterEncoding("UTF-8");
		
		return viewResolver;
	}
	
	
}
