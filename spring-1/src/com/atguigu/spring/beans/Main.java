package com.atguigu.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
//		HelloWorld helloWorld = new HelloWorld();
//		helloWorld.setName("atguigu");
//		helloWorld.hello();
		
		//1.创建Spring IOC容器对象
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.从IOC容器中获取bean实例
//		HelloWorld helloWorld = (HelloWorld)ctx.getBean("helloWorld");
		HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		//3.调用方法
		helloWorld.hello();
		
		Car car = (Car)ctx.getBean("car");
		System.out.println(car);
		
		car = (Car)ctx.getBean("car2");
		System.out.println(car);
		
		Person person = (Person)ctx.getBean("person");
		System.out.println(person);
		
		Person person2 = (Person)ctx.getBean("person2");
		System.out.println(person2);
	}
}
