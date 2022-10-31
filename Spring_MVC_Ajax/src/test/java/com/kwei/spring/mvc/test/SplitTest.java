package com.kwei.spring.mvc.test;

import org.junit.Test;

public class SplitTest {

	@Test
	public void splitTest() {
		
		String str = "123.abc";
		str = str.split("\\.")[1];
		System.out.println(str);
	}
	
}
