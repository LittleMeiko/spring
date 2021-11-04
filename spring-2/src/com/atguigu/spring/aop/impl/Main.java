package com.atguigu.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ArithmeticCaculator arithmeticCaculator = ctx.getBean(ArithmeticCaculator.class);
		
		int result = arithmeticCaculator.add(3, 6);
		System.out.println("result:" + result);
		
		result = arithmeticCaculator.div(6, 3);
		System.out.println("result:" + result);
	}
}
