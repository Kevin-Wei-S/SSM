package com.kwei.spring.test;

import org.junit.Test;

import com.kwei.spring.proxy.Calculator;
import com.kwei.spring.proxy.CalculatorImpl;
import com.kwei.spring.proxy.CalculatorStaticProxy;
import com.kwei.spring.proxy.ProxyFactory;

public class ProxyTest {

	/**
	 * 	動態代理有兩種:
	 * 		1. jdk動態代理: 要求必須有接口, 最終生成的代理類與目標類實現相同的接口
	 * 					    且在com.sun.proxy包下, 類名為$proxy2(序數).
	 * 		2. cglib動態代理: 不須有接口, 最終生成的代理類	會繼承目標類,
	 * 						  並且與目標類在相同的包下.
	 * 
	 */
	
	@Test
	public void testProxyFactory() {
		
		ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
		Calculator proxy = (Calculator) proxyFactory.getProxy();
		System.out.println(proxy.add(100, 2));
		System.out.println();
		System.out.println(proxy.sub(100, 2));
		System.out.println();
		System.out.println(proxy.mul(100, 2));
		System.out.println();
		System.out.println(proxy.div(100, 2));
		
	}
	
	
	@Test
	public void testProxy() {
		
		CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
		System.out.println(proxy.add(100, 2));
		System.out.println();
		System.out.println(proxy.sub(100, 2));
		System.out.println();
		System.out.println(proxy.mul(100, 2));
		System.out.println();
		System.out.println(proxy.div(100, 2));
	}
	
}
