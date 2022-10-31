package com.kwei.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.stereotype.Component;

@Component
public class LoggerAspect {

		public void beforeAdviceMethod(JoinPoint joinPoint) {
			System.out.println("LoggerAspect, ��k: " + 
					joinPoint.getSignature().getName() + ", �Ѽ�: " + Arrays.toString(joinPoint.getArgs()));
		} 
		
		
		public void afterAdviceMethod(JoinPoint joinPoint) {
			Signature signature = joinPoint.getSignature();
			System.out.println("LoggerAspect, ��k: " + signature.getName() + ", ���槹��!");
		}
		
		
		public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
			Signature signature = joinPoint.getSignature();
			System.out.println("LoggerAspect, "
					+ "��k: " + signature.getName() + ", ���G: " + result);
		}
		
		
		public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable e) {
			Signature signature = joinPoint.getSignature();
			System.out.println("LoggerAspect, ��k: " +  signature.getName() + 
									", ���`: " + e);
		}
		
		
		public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
			Object result = null;
			try {
				System.out.println("��¶�q�� --> �e�m�q��");
				// ��ܥؼй�H��k������ 
				// �p�P�ʺA�N�z: result = method.invoke(target, args);
				result = joinPoint.proceed();
				System.out.println("��¶�q�� --> ��^�q��");
			} catch (Throwable e) {
				e.printStackTrace();
				System.out.println("��¶�q�� --> ���`�q��");
			} finally {
				System.out.println("��¶�q�� --> ��m�q��");
			}
			return result;
		}
	
}
