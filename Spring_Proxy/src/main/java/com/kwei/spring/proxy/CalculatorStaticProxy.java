package com.kwei.spring.proxy;

public class CalculatorStaticProxy implements Calculator {

	private Calculator target;
	
	public CalculatorStaticProxy(Calculator target) {
		super();
		this.target = target;
	}

	public Integer add(int i, int j) {
		System.out.println("ら粁, よ猭: add, 把计: " + i + ", 把计: " + j);
		Integer result = target.add(i, j);
		System.out.println("ら粁, よ猭: add, 挡狦: " + result);
		return result;
	}

	public Integer sub(int i, int j) {
		System.out.println("ら粁, よ猭: sub, 把计: " + i + ", 把计: " + j);
		Integer result = target.sub(i, j);
		System.out.println("ら粁, よ猭: sub, 挡狦: " + result);
		return result;
	}

	public Integer mul(int i, int j) {
		System.out.println("ら粁, よ猭: mul, 把计: " + i + ", 把计: " + j);
		Integer result = target.mul(i, j);
		System.out.println("ら粁, よ猭: mul, 挡狦: " + result);
		return result;
	}

	public Integer div(int i, int j) {
		System.out.println("ら粁, よ猭: div, 把计: " + i + ", 把计: " + j);
		Integer result = target.div(i, j);
		System.out.println("ら粁, よ猭: div, 挡狦: " + result);
		return result;
	}

	
}
