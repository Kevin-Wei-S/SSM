package com.kwei.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/test/searchroot")
	public String testRequestPath() {
		return "success";
	}
	
	@RequestMapping("/test/exception")
	public String testExceptionResolver() {
		int exception = 10 / 0;
		System.out.println(exception);
		return "success";
	}
	
	@RequestMapping("/test/exception/annotation")
	public String testExceptionByAnnotation() {
		String str = null;
		System.out.println(str.toString());
		return "success";
	}
	
}
