package com.kwei.spring.test;

import org.junit.Test;

import com.kwei.spring.proxy.Calculator;
import com.kwei.spring.proxy.CalculatorImpl;
import com.kwei.spring.proxy.CalculatorStaticProxy;
import com.kwei.spring.proxy.ProxyFactory;

public class ProxyTest {

	/**
	 * 	�ʺA�N�z�����:
	 * 		1. jdk�ʺA�N�z: �n�D���������f, �̲ץͦ����N�z���P�ؼ�����{�ۦP�����f
	 * 					    �B�bcom.sun.proxy�]�U, ���W��$proxy2(�Ǽ�).
	 * 		2. cglib�ʺA�N�z: ���������f, �̲ץͦ����N�z��	�|�~�ӥؼ���,
	 * 						  �åB�P�ؼ����b�ۦP���]�U.
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
