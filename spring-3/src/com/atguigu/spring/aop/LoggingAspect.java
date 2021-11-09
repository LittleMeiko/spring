package com.atguigu.spring.aop;

import java.util.Arrays;

import javax.management.RuntimeErrorException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value = 2)
@Aspect
@Component
public class LoggingAspect {
	
	//����һ���������������������ʽ��һ��ģ��÷����в�����Ҫ��������Ĵ���
	@Pointcut("execution(* com.atguigu.spring.aop.ArithmeticCaculatorImpl.*(..))")
	public void declareJoinpointExpression() {}
	
	/**
	 * ǰ��֪ͨ���ڷ���ִ��ǰִ��
	 * 
	 * @param joinPoint
	 */
	@Before("declareJoinpointExpression()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("Atguigu->" + " The method " + methodName + " begins with " + Arrays.asList(args));
	}
	
	/**
	 * ����֪ͨ���ڷ���ִ����֮��ִ��
	 * ���۷����Ƿ��׳��쳣
	 * 
	 * @param joinPoint
	 */
	@After("declareJoinpointExpression()")
	public void AfterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("Atguigu->" + " The method " + methodName + " run complete...");
	}
	
	/**
	 * ����֪ͨ���ڷ�������ִ�����ִ�еĴ���
	 * ����֪ͨ���Ի�ȡ������ִ�����Ľ��
	 * 
	 * @param joinPoint
	 * @param result
	 */
	@AfterReturning(value="declareJoinpointExpression()", returning = "result")
	public void methodReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}
	
	/**
	 * �쳣֪ͨ���ڷ��������쳣֮��ִ�еĴ���
	 * ���Է��ʵ��쳣�����ҿ���ָ���ڳ����ض��쳣ʱִ��֪ͨ����
	 * 
	 * @param joinPoint
	 * @param ex
	 */
	@AfterThrowing(value="declareJoinpointExpression()", throwing = "ex")
	public void methodThrowing(JoinPoint joinPoint, NullPointerException ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occured exception:" + ex);
	}
	
	/**
	 * ����֪ͨ������ ProceedingJoinPoint ���͵Ĳ���
	 * ����֪ͨ�����ڶ�̬�����ȫ���̣�ProceedingJoinPoint ���͵Ĳ������Ծ����Ƿ�ִ��Ŀ�귽��
	 * ����֪ͨ�����з���ֵ������ֵ��ΪĿ�귽���ķ���ֵ
	 * 
	 * @param pjp
	 */
//	@Around("execution(* com.atguigu.spring.aop.ArithmeticCaculatorImpl.*(..))")
//	public Object methodAround(ProceedingJoinPoint pjp) {
//		Object result = null;
//		String methodName = pjp.getSignature().getName();
//		try {
//			//ǰ��֪ͨ
//			System.out.println("The method " + methodName + " begin with " + Arrays.asList(pjp.getArgs()));
//			result = pjp.proceed();
//			//����֪ͨ
//			System.out.println("The method " + methodName + " ends with " + result);
//		} catch (Throwable e) {
//			//�쳣֪ͨ
//			System.out.println("The method " + methodName + " occured exception:" + e);
//		}
//		//����֪ͨ
//		System.out.println("The method " + methodName + " ends");
//		
//		return result;
//	}
}
