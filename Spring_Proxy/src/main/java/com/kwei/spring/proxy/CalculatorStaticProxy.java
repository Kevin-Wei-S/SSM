package com.kwei.spring.proxy;

public class CalculatorStaticProxy implements Calculator {

	private Calculator target;
	
	public CalculatorStaticProxy(Calculator target) {
		super();
		this.target = target;
	}

	public Integer add(int i, int j) {
		System.out.println("��x, ��k: add, �Ѽ�: " + i + ", �Ѽ�: " + j);
		Integer result = target.add(i, j);
		System.out.println("��x, ��k: add, ���G: " + result);
		return result;
	}

	public Integer sub(int i, int j) {
		System.out.println("��x, ��k: sub, �Ѽ�: " + i + ", �Ѽ�: " + j);
		Integer result = target.sub(i, j);
		System.out.println("��x, ��k: sub, ���G: " + result);
		return result;
	}

	public Integer mul(int i, int j) {
		System.out.println("��x, ��k: mul, �Ѽ�: " + i + ", �Ѽ�: " + j);
		Integer result = target.mul(i, j);
		System.out.println("��x, ��k: mul, ���G: " + result);
		return result;
	}

	public Integer div(int i, int j) {
		System.out.println("��x, ��k: div, �Ѽ�: " + i + ", �Ѽ�: " + j);
		Integer result = target.div(i, j);
		System.out.println("��x, ��k: div, ���G: " + result);
		return result;
	}

	
}
