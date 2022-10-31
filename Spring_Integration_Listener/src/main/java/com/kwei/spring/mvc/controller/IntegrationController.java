package com.kwei.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kwei.spring.mvc.service.IntegrationService;

@Controller
public class IntegrationController {

	@Autowired
	private IntegrationService service = new IntegrationService();
	
	@RequestMapping("/greet")
	public String greet(Model model) {
		
		String greet = service.greet();
		model.addAttribute("greet", greet);
		
		return "success";
	}
	
}
