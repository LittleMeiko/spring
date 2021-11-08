package com.atguigu.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ArithmeticCaculator arithmeticCaculator = (ArithmeticCaculator)ctx.getBean("arithmeticCaculator");
		int result = arithmeticCaculator.add(2, 4);
//		System.out.println("result:" + result);
		
		result = arithmeticCaculator.div(4, 2);
//		System.out.println("result:" + result);
	}
}
