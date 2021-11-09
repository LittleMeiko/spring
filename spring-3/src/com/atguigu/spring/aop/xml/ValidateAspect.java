package com.atguigu.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class ValidateAspect {

	public void validateArgs(JoinPoint joinPoint) {
		System.out.println("Validate:" + Arrays.asList(joinPoint.getArgs()));
	}
}
