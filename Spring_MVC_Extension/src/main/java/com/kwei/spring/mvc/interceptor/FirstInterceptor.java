package com.kwei.spring.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * Date: 2022年9月6日上午11:23:43
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *
 *	攔截器的三個方法:
 *		preHandle(): 在控制器方法處理請求前執行, 其返回值為Boolean類型,
 *					 false為攔截; true為放行;
 *		postHandle(): 在控制器方法處理請求後執行, 無返回值. 
 *		afterCompletion(): 在控制器方法處理請求後, 
 *						   且thymeleafViewResolver渲染完視圖後執行.
 *	
 *	多個攔截器的執行順序和在springmvc.xml配置的順序有關
 *		preHandle(): 按照配置順序執行
 *		postHandle(): 按照配置的逆順序執行
 *		afterCompletion(): 按照配置的反順序執行
 *	若攔截器中有特定攔截器preHandle的返回值為false
 *		特定攔截器preHandle的返回值為false, 則此攔截器之前的攔截器都會執行preHandle().
 *		所有的攔截器的postHandle()皆不執行
 *		特定攔截器preHandle()返回false之前的攔截器皆會執行afterCompletion()
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
