package com.atguigu.spring.aop.helloworld;

public class Main {
	
	public static void main(String[] args) {
		ArithmeticCaculator caculator = new ArithmeticCaculatorImpl();
		ArithmeticCaculator proxy = new ArithmeticCaculatorLoggingProxy(caculator).getLoggingProxy();
		
		int result = proxy.add(1, 2);
		System.out.println("-->" + result);
		result = proxy.div(4, 2);
		System.out.println("-->" + result);
	}
}
