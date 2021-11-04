package com.atguigu.spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	//前置通知
	@Before("execution(* com.atguigu.spring.aop.impl.*.*(int, int))")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		
		System.out.println("The method " + methodName + " begins with" + Arrays.asList(args));
	}
	
	//后置通知:在目标方法执行之后执行(无论是否发生异常),此时还不能访问目标方法执行的结果
	@After("execution(* com.atguigu.spring.aop.impl.*.*(int, int))")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("The method " + methodName + " ends" );
	}
	
	//返回通知
	@AfterReturning("execution(* com.atguigu.spring.aop.impl.*.*(int, int))")
	public void afterReturn(JoinPoint joinPoint) {
		
	}
}
