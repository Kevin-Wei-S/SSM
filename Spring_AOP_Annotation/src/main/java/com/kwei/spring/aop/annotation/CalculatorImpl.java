package com.kwei.spring.aop.annotation;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator {

	public Integer add(int i, int j) {
		Integer result = i + j;
		System.out.println("よ猭ず场, result: " + result);
		return result;
	}

	public Integer sub(int i, int j) {
		Integer result = i - j;
		System.out.println("よ猭ず场, result: " + result);
		return result;
	}

	public Integer mul(int i, int j) {
		Integer result = i * j;
		System.out.println("よ猭ず场, result: " + result);
		return result;
	}

	public Integer div(int i, int j) {
		Integer result = i / j;
		System.out.println("よ猭ず场, result: " + result);
		return result;
	}
	
}
