package com.kwei.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	// /: 伺服器絕對路徑的標示-localhost:8080/Spring_MVC_HelloWorld/
	@RequestMapping("/")
	public String portal() {
		// 將邏輯視圖返回
		return "index";
	}
	
}
