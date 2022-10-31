package com.kwei.spring.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

// 將當前類標示為異常處理的組件
@ControllerAdvice
public class ExceptionController {
	
	// 設置要處理的異常類型
	@ExceptionHandler(NullPointerException.class)
	public String handleExceptionByAnnotation(Throwable ex, Model model) {
		model.addAttribute("ex", ex);	
		return "error";
	}
	
}
