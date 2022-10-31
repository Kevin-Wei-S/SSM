package com.kwei.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 *  動態代理類
 * Date: 2022年8月24日下午4:11:35
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description:
 *
 */
public class ProxyFactory {

	private Object target;
	
	public ProxyFactory(Object target) {
		this.target = target;
	}
	
	public Object getProxy() {
		/**
		 *  ClassLoader loader: 指定加載動態生成的代理類的類加載器
		 *  					(所有類都必須先經過加載才可以使用)
         *  Class[] interfaces: 獲取目標對象所實現的所有接口的Class對象的數組
         *  InvocationHandler h: 設置代理類中的抽象方法如何重寫
		 */
		
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class<?>[] interfaces = target.getClass().getInterfaces();
		InvocationHandler h = new InvocationHandler() {
			// 代理對象要如何執行方法
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				/**
				 * 	proxy: 表示代理對象
				 * 	method: 要執行的方法(要實現的抽象方法)
				 *  args: 要執行方法的參數列表
				 * 
				 */
				
				Object result = null;
				try {
					System.out.println("日誌, 方法: " + method.getName() + ", 參數: " + Arrays.toString(args));
					// 調用目標對象的方法
					result = method.invoke(target, args);
					System.out.println("日誌, 方法: " + method.getName() + ", 結果: " + result);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("日誌, 方法: " + method.getName() + ", 異常: " + e);
				} finally {
					System.out.println("日誌, 方法: " + method.getName() + ", 方法執行完畢!");
				}
				return result;
			}
		};
		
		return Proxy.newProxyInstance(classLoader, interfaces, h);
				
	}
	
}
