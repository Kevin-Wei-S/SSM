package com.kwei.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	// /: ���A��������|���Х�-localhost:8080/Spring_MVC_HelloWorld/
	@RequestMapping("/")
	public String portal() {
		// �N�޿���Ϫ�^
		return "index";
	}
	
}
