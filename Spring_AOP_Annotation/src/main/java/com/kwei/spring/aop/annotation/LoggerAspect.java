package com.kwei.spring.aop.annotation;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * Date: 2022年8月25日上午10:36:24
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description: 
 * 	
 * 1. 在切面中, 需要通過指定的註解將方法標示為通知方法.
 * 		@Before: 前置通知, 在目標對象方法執行之前執行.
 * 		@After: 後置通知, 在目標對象finally子句中執行.
 * 		@AfterReturning: 返回通知, 在目標對象方法返回值之後執行.
 * 		@AfterThrowing: 異常通知, 在目標對象catch子句中執行.
 *	
 * 2. 切入點表達式: 設置在標示"通知"的註解的value屬性中
 *		execution(public int com.kwei.spring.aop.annotation.CalculatorImpl.add(int, int))
 *		execution(* com.kwei.spring.aop.annotation.CalculatorImpl.*(..))
 *			x. 第一個*表示任意的訪問修飾符和返回值類型
 *			y. 第二個*表示當前類型中的任意的方法
 *			z. (..)表示任意的參數列表
 *			a. 類的地方也可以使用*表示當前包下的任意類型
 *
 *	3. 重用切入點表達式
 *		// @Pointcut 聲明一個重用的切入點表達式
 *		@Pointcut("execution(* com.kwei.spring.aop.annotation.CalculatorImpl.*(..))")
		public void pointCut() {}
		使用方式:
			@Before("pointCut()")
 *
 *	4. 獲取連接點的訊息: 
 *		在目標對象的"橫切關注點"抽取至切面類"通知"方法, 
 *		在通知方法參數列表中添加JoinPoint類型的參數, 可以獲得連接點joinPoint, 
 *		進而獲得"連接點"對應目標對象"方法"的訊息.
 *			joinPoint.getName(): 獲取目標對象方法名
 *			joinPoint.getArges(): 獲取目標對象方法的參數列表
 *	
 *	5. 切面的優先級:
 *		可以通過@Order註解的value屬性設置優先級, 
 *		默認值為Integer.MAX_VALUE(最低優先級),
 *		value屬性值越小, 優先級越高. 
 *
 */
@Component
@Aspect // 將當前組件標示為切面
public class LoggerAspect {

	// 切入點表達式重用
	@Pointcut("execution(* com.kwei.spring.aop.annotation.CalculatorImpl.*(..))")
	public void pointCut() {}
	
	//@Before("execution(public Integer com.kwei.spring.aop.annotation.CalculatorImpl.add(int, int))") // 切入點表達式
	//@Before("execution(* com.kwei.spring.aop.annotation.CalculatorImpl.*(..))")
	@Before("pointCut()")
	public void beforeAdviceMethod(JoinPoint joinPoint) {
		System.out.println("LoggerAspect, 方法: " + 
				joinPoint.getSignature().getName() + ", 參數: " + Arrays.toString(joinPoint.getArgs()));
	} 
	
	@After("pointCut()")
	public void afterAdviceMethod(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("LoggerAspect, 方法: " + signature.getName() + ", 執行完畢!");
	}
	
	/**
	 *  在"返回通知"中獲取目標對象方法的返回值, 
	 *  只需要通過@AfterReturning註解的returning屬性,
	 *  就可以將通知方法的參數列表指定特定參數接收目標對象方法的返回值,
	 *  "通知方法"的"返回值接收參數名"必須與returning屬性值一致.
	 * 
	 */
	@AfterReturning(value="pointCut()", returning="result")
	public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
		Signature signature = joinPoint.getSignature();
		System.out.println("LoggerAspect, "
				+ "方法: " + signature.getName() + ", 結果: " + result);
	}
	
	/**
	 *  在"異常通知"中獲取目標對象方法拋出的異常, 
	 *  只需要通過@AfterThrowing註解的throwing屬性,
	 *  就可以將通知方法的參數列表指定特定參數 接收 目標對象方法拋出的異常,
	 *  "通知方法"的"異常接收參數名"必須與throwing屬性值一致.
	 * 
	 */
	@AfterThrowing(value="pointCut()", throwing="e")
	public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable e) {
		Signature signature = joinPoint.getSignature();
		System.out.println("LoggerAspect, 方法: " +  signature.getName() + 
								", 異常: " + e);
	}
	
	// 環繞通知方法的返回值, 一定要和目標對象方法的返回值一致.
	@Around(value="pointCut()")
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
