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
 * Date: 2022�~8��25��W��10:36:24
 * Author: K-Wei
 * Email: a8566248@gmail.com
 * Description: 
 * 	
 * 1. �b������, �ݭn�q�L���w�����ѱN��k�Хܬ��q����k.
 * 		@Before: �e�m�q��, �b�ؼй�H��k���椧�e����.
 * 		@After: ��m�q��, �b�ؼй�Hfinally�l�y������.
 * 		@AfterReturning: ��^�q��, �b�ؼй�H��k��^�Ȥ������.
 * 		@AfterThrowing: ���`�q��, �b�ؼй�Hcatch�l�y������.
 *	
 * 2. ���J�I��F��: �]�m�b�Х�"�q��"�����Ѫ�value�ݩʤ�
 *		execution(public int com.kwei.spring.aop.annotation.CalculatorImpl.add(int, int))
 *		execution(* com.kwei.spring.aop.annotation.CalculatorImpl.*(..))
 *			x. �Ĥ@��*��ܥ��N���X�ݭ׹��ũM��^������
 *			y. �ĤG��*��ܷ�e�����������N����k
 *			z. (..)��ܥ��N���ѼƦC��
 *			a. �����a��]�i�H�ϥ�*��ܷ�e�]�U�����N����
 *
 *	3. ���Τ��J�I��F��
 *		// @Pointcut �n���@�ӭ��Ϊ����J�I��F��
 *		@Pointcut("execution(* com.kwei.spring.aop.annotation.CalculatorImpl.*(..))")
		public void pointCut() {}
		�ϥΤ覡:
			@Before("pointCut()")
 *
 *	4. ����s���I���T��: 
 *		�b�ؼй�H��"������`�I"����ܤ�����"�q��"��k, 
 *		�b�q����k�ѼƦC���K�[JoinPoint�������Ѽ�, �i�H��o�s���IjoinPoint, 
 *		�i����o"�s���I"�����ؼй�H"��k"���T��.
 *			joinPoint.getName(): ����ؼй�H��k�W
 *			joinPoint.getArges(): ����ؼй�H��k���ѼƦC��
 *	
 *	5. �������u����:
 *		�i�H�q�L@Order���Ѫ�value�ݩʳ]�m�u����, 
 *		�q�{�Ȭ�Integer.MAX_VALUE(�̧C�u����),
 *		value�ݩʭȶV�p, �u���ŶV��. 
 *
 */
@Component
@Aspect // �N��e�ե�Хܬ�����
public class LoggerAspect {

	// ���J�I��F������
	@Pointcut("execution(* com.kwei.spring.aop.annotation.CalculatorImpl.*(..))")
	public void pointCut() {}
	
	//@Before("execution(public Integer com.kwei.spring.aop.annotation.CalculatorImpl.add(int, int))") // ���J�I��F��
	//@Before("execution(* com.kwei.spring.aop.annotation.CalculatorImpl.*(..))")
	@Before("pointCut()")
	public void beforeAdviceMethod(JoinPoint joinPoint) {
		System.out.println("LoggerAspect, ��k: " + 
				joinPoint.getSignature().getName() + ", �Ѽ�: " + Arrays.toString(joinPoint.getArgs()));
	} 
	
	@After("pointCut()")
	public void afterAdviceMethod(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("LoggerAspect, ��k: " + signature.getName() + ", ���槹��!");
	}
	
	/**
	 *  �b"��^�q��"������ؼй�H��k����^��, 
	 *  �u�ݭn�q�L@AfterReturning���Ѫ�returning�ݩ�,
	 *  �N�i�H�N�q����k���ѼƦC����w�S�w�ѼƱ����ؼй�H��k����^��,
	 *  "�q����k"��"��^�ȱ����ѼƦW"�����Preturning�ݩʭȤ@�P.
	 * 
	 */
	@AfterReturning(value="pointCut()", returning="result")
	public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
		Signature signature = joinPoint.getSignature();
		System.out.println("LoggerAspect, "
				+ "��k: " + signature.getName() + ", ���G: " + result);
	}
	
	/**
	 *  �b"���`�q��"������ؼй�H��k�ߥX�����`, 
	 *  �u�ݭn�q�L@AfterThrowing���Ѫ�throwing�ݩ�,
	 *  �N�i�H�N�q����k���ѼƦC����w�S�w�Ѽ� ���� �ؼй�H��k�ߥX�����`,
	 *  "�q����k"��"���`�����ѼƦW"�����Pthrowing�ݩʭȤ@�P.
	 * 
	 */
	@AfterThrowing(value="pointCut()", throwing="e")
	public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable e) {
		Signature signature = joinPoint.getSignature();
		System.out.println("LoggerAspect, ��k: " +  signature.getName() + 
								", ���`: " + e);
	}
	
	// ��¶�q����k����^��, �@�w�n�M�ؼй�H��k����^�Ȥ@�P.
	@Around(value="pointCut()")
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
