package com.atguigu.spring.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
		ArithmeticCaculator arithmeticCaculator = (ArithmeticCaculator)ctx.getBean("arithmeticCaculator");
		System.out.println(arithmeticCaculator);
		int result = arithmeticCaculator.add(2, 4);
		System.out.println("result:" + result);
		result = arithmeticCaculator.div(4, 2);
		System.out.println("result:" + result);
	}
}
