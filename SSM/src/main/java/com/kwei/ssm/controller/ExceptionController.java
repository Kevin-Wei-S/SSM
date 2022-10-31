package com.kwei.ssm.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(ArithmeticException.class)
	public String arithmeticException(Throwable ex, Model model) {
		model.addAttribute("ex", ex);
		return "error";
	}
	
}
