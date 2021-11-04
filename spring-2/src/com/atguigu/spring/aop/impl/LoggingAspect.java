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
	
	//ǰ��֪ͨ
	@Before("execution(* com.atguigu.spring.aop.impl.*.*(int, int))")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		
		System.out.println("The method " + methodName + " begins with" + Arrays.asList(args));
	}
	
	//����֪ͨ:��Ŀ�귽��ִ��֮��ִ��(�����Ƿ����쳣),��ʱ�����ܷ���Ŀ�귽��ִ�еĽ��
	@After("execution(* com.atguigu.spring.aop.impl.*.*(int, int))")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("The method " + methodName + " ends" );
	}
	
	//����֪ͨ
	@AfterReturning("execution(* com.atguigu.spring.aop.impl.*.*(int, int))")
	public void afterReturn(JoinPoint joinPoint) {
		
	}
}
