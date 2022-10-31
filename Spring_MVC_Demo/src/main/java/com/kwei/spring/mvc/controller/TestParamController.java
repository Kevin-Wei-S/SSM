package com.kwei.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kwei.spring.mvc.pojo.User;

/**
 * 
 * Date: 2022年8月30日下午4:36:10
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *	獲取請求參數的方式:
 *		1. 通過ServletAPI獲取
 *			只需要在控制器方法的型參位置設置HttpServletRequset類型的型參, 
 *			就可以在控制器方法內使用request對象來獲取請求參數.	
 *
 *		2. 通過控制器方法的型參獲取請求參數
 *			只需要在控制器方法的型參位置, 設置一組型參, 其型參名與請求參數(name)名一致.
 *
 *		3. @RequestParam: 將請求參數與控制器方法的形參綁定 
 *		   @RequestParam的屬性:
 *				3.1. value: 與控制器方法的型參綁定的請求參數名
 *				3.2. required(true/false)默認為true: 請求參數是否不為null, 
 *					 若為null則報錯:	HTTP Status 400 – Bad Request
 *				3.3. defaultValue: 請求參數如果為null或"", 則使用默認值,
 *								   與required屬性值無關.
 *
 *		4. @RequestHeader: 將請求頭訊息的key與控制器方法的形參進行綁定
 *
 *		5. @CookieValue: 將Cookie數據與控制器方法的型參進行綁定
 *
 *		6. 通過控制器的方法的實體類類型的型參獲取請求參數
 *			需要在控制器方法的型參位置設置實體類類型的型參, 要保證實體類中的屬性名,
 *			與請求參數名保持一致, 可以透過實體類類型的型參獲取請求參數.	
 *
 *		7. 解決請求參數的亂碼問題	
 *			在web.xml中配置Spring的編碼過濾器(CharacterEncodingFilter)
 *		
 */

@Controller
public class TestParamController {

	@RequestMapping("/param/servletAPI")
	public String getParamByServletAPI(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username: " + username + ", password: " + password);
		return "tranquil";
	}
	
	@RequestMapping("/param/springMVC")
	public String getParamBySpringMVC(
			@RequestParam(value = "userName", required = true) String username, 
			String password,
			@RequestHeader("referer") String referer,
			@CookieValue("JSESSIONID") String jsessionId) {
		System.out.println("username: " + username + ", password: " + password);
		System.out.println("Header-Referer: " + referer);
		// 須先與執行與HttpSession有關操作, 才會生成JSESSIONID.
		System.out.println("Cookie-JSESSIONID: " + jsessionId);
		return "tranquil";
	}
	
	@RequestMapping("/param/springmvc/pojo")
	public String getParamBySpringMVCWithPOJO(User user) {
		System.out.println(user);
		return "tranquil";
	}
	
}
