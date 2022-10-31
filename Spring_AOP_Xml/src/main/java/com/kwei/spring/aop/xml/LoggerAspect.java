package com.kwei.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.stereotype.Component;

@Component
public class LoggerAspect {

		public void beforeAdviceMethod(JoinPoint joinPoint) {
			System.out.println("LoggerAspect, 方法: " + 
					joinPoint.getSignature().getName() + ", 參數: " + Arrays.toString(joinPoint.getArgs()));
		} 
		
		
		public void afterAdviceMethod(JoinPoint joinPoint) {
			Signature signature = joinPoint.getSignature();
			System.out.println("LoggerAspect, 方法: " + signature.getName() + ", 執行完畢!");
		}
		
		
		public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
			Signature signature = joinPoint.getSignature();
			System.out.println("LoggerAspect, "
					+ "方法: " + signature.getName() + ", 結果: " + result);
		}
		
		
		public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable e) {
			Signature signature = joinPoint.getSignature();
			System.out.println("LoggerAspect, 方法: " +  signature.getName() + 
									", 異常: " + e);
		}
		
		
		public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
			Object result = null;
			try {
				System.out.println("環繞通知 --> 前置通知");
				// 表示目標對象方法的執行 
				// 如同動態代理: result = method.invoke(target, args);
				result = joinPoint.proceed();
				System.out.println("環繞通知 --> 返回通知");
			} catch (Throwable e) {
				e.printStackTrace();
				System.out.println("環繞通知 --> 異常通知");
			} finally {
				System.out.println("環繞通知 --> 後置通知");
			}
			return result;
		}
	
}
