package com.atguigu.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//����ͨ��@Orderע��ָ����������ȼ���ֵԽС���ȼ�Խ��
@Order(value = 1)
@Aspect
@Component
public class ValidateAspect {

	@Before("execution(public int com.atguigu.spring.aop.ArithmeticCaculatorImpl.*(..))")
	public void validateArgs(JoinPoint joinPoint) {
		System.out.println("Validate:" + Arrays.asList(joinPoint.getArgs()));
	}
}
