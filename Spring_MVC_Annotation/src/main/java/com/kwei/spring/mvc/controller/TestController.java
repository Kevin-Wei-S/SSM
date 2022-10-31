package com.kwei.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/test/exception/annotation")
	public String testExceptionByAnnotation() {
		System.out.println(10/0);
		return "success";
	}
	
}
