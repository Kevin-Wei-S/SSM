package com.kwei.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 *  �ʺA�N�z��
 * Date: 2022�~8��24��U��4:11:35
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
		 *  ClassLoader loader: ���w�[���ʺA�ͦ����N�z�������[����
		 *  					(�Ҧ������������g�L�[���~�i�H�ϥ�)
         *  Class[] interfaces: ����ؼй�H�ҹ�{���Ҧ����f��Class��H���Ʋ�
         *  InvocationHandler h: �]�m�N�z��������H��k�p�󭫼g
		 */
		
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class<?>[] interfaces = target.getClass().getInterfaces();
		InvocationHandler h = new InvocationHandler() {
			// �N�z��H�n�p������k
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				/**
				 * 	proxy: ��ܥN�z��H
				 * 	method: �n���檺��k(�n��{����H��k)
				 *  args: �n�����k���ѼƦC��
				 * 
				 */
				
				Object result = null;
				try {
					System.out.println("��x, ��k: " + method.getName() + ", �Ѽ�: " + Arrays.toString(args));
					// �եΥؼй�H����k
					result = method.invoke(target, args);
					System.out.println("��x, ��k: " + method.getName() + ", ���G: " + result);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("��x, ��k: " + method.getName() + ", ���`: " + e);
				} finally {
					System.out.println("��x, ��k: " + method.getName() + ", ��k���槹��!");
				}
				return result;
			}
		};
		
		return Proxy.newProxyInstance(classLoader, interfaces, h);
				
	}
	
}
