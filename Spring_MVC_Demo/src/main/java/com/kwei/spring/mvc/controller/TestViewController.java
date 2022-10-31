package com.kwei.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestViewController {

	@RequestMapping("/view/thymeleaf")
	public String testThymeleafView() {
		return "tranquil";
	}
	
	@RequestMapping("/view/forward")
	public String testInternalResourceView() {
		return "forward:/scope/modelmap";		
	}
	
	@RequestMapping("/view/redirect")
	public String testRedirectView() {
		return "redirect:/scope/model";
	}
	
}
