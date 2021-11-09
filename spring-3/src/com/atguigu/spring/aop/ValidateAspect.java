package com.atguigu.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//可以通过@Order注解指定切面的优先级，值越小优先级越高
@Order(value = 1)
@Aspect
@Component
public class ValidateAspect {

	@Before("com.atguigu.spring.aop.LoggingAspect.declareJoinpointExpression()")
	public void validateArgs(JoinPoint joinPoint) {
		System.out.println("Validate:" + Arrays.asList(joinPoint.getArgs()));
	}
}
