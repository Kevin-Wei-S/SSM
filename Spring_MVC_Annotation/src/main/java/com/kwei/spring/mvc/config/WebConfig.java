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
 * Date: 2022年9月6日下午4:20:49
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description: 代替SpringMVC的配置文件
 *	掃描組件、視圖解析器、默認的servlet、mvc的註解驅動、
 *	視圖控制器、文件上傳解析器、攔截器、異常解析器	
 *
 *
 */

// 標示為一個配置類
@Configuration
// 掃描組件
@ComponentScan("com.kwei.spring.mvc.controller")
// 開啟Mvc的註解驅動
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	// 使用默認Servlet處理靜態資源
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// 設置視圖控制器
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}
	
	// 設置文件上傳解析器
	@Bean // 可以將標示@Bean方法的返回值作為Bean且交給IOC進行管理, Bean的id即為方法名. 
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
	
	// 設置攔截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new FirstInterceptor()).
			addPathPatterns("/**").excludePathPatterns("/abc");
	}

	// 配置異常解析器
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		Properties prop = new Properties();
		prop.setProperty("java.lang.ArithmeticException", "error");
		exceptionResolver.setExceptionMappings(prop);
		exceptionResolver.setExceptionAttribute("ex");
		resolvers.add(exceptionResolver);
	}
	
	// 設置視圖解析器
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
