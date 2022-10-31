package com.kwei.spring.proxy;

public class CalculatorImpl implements Calculator {

	public Integer add(int i, int j) {
		Integer result = i + j;
		System.out.println("方法內部, result: " + result);
		return result;
	}

	public Integer sub(int i, int j) {
		Integer result = i - j;
		System.out.println("方法內部, result: " + result);
		return result;
	}

	public Integer mul(int i, int j) {
		Integer result = i * j;
		System.out.println("方法內部, result: " + result);
		return result;
	}

	public Integer div(int i, int j) {
		Integer result = i / j;
		System.out.println("方法內部, result: " + result);
		return result;
	}
	
}
