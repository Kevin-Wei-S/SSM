package com.kwei.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class ValidateAspect {

	public void beforeAdviceMethod(JoinPoint joinPoint) {
		
		System.out.println("Validate --> «e¸m³qª¾");
		
	}
	
}
