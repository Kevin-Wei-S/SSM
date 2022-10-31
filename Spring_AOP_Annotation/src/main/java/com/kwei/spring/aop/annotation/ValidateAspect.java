package com.kwei.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1) // �������u����, �Ʀr�V�p, �u���ŶV��, �w�]��Integer.MAX_VALUE.
public class ValidateAspect {

	
	@Before("execution(* com.kwei.spring.aop.annotation.Calculator.*(..))")
	//@Before("com.kwei.spring.aop.annotation.LoggerAspect.pointCut()")
	public void beforeAdviceMethod(JoinPoint joinPoint) {
		
		System.out.println("Validate --> �e�m�q��");
		
	}
	
	
}
