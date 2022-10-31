package com.kwei.spring.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

// �N��e���Хܬ����`�B�z���ե�
@ControllerAdvice
public class ExceptionController {
	
	// �]�m�n�B�z�����`����
	@ExceptionHandler(NullPointerException.class)
	public String handleExceptionByAnnotation(Throwable ex, Model model) {
		model.addAttribute("ex", ex);	
		return "error";
	}
	
}
