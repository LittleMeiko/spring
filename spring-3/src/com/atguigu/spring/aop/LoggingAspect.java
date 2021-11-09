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
	
	//定义一个方法用于声明切入点表达式，一般的，该方法中不再需要添加其它的代码
	@Pointcut("execution(* com.atguigu.spring.aop.ArithmeticCaculatorImpl.*(..))")
	public void declareJoinpointExpression() {}
	
	/**
	 * 前置通知：在方法执行前执行
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
	 * 后置通知：在方法执行完之后执行
	 * 无论方法是否抛出异常
	 * 
	 * @param joinPoint
	 */
	@After("declareJoinpointExpression()")
	public void AfterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("Atguigu->" + " The method " + methodName + " run complete...");
	}
	
	/**
	 * 返回通知：在方法正常执行完后执行的代码
	 * 返回通知可以获取到方法执行完后的结果
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
	 * 异常通知：在方法出现异常之后执行的代码
	 * 可以访问到异常对象；且可以指定在出现特定异常时执行通知代码
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
	 * 环绕通知必须有 ProceedingJoinPoint 类型的参数
	 * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
	 * 环绕通知必须有返回值，返回值即为目标方法的返回值
	 * 
	 * @param pjp
	 */
//	@Around("execution(* com.atguigu.spring.aop.ArithmeticCaculatorImpl.*(..))")
//	public Object methodAround(ProceedingJoinPoint pjp) {
//		Object result = null;
//		String methodName = pjp.getSignature().getName();
//		try {
//			//前置通知
//			System.out.println("The method " + methodName + " begin with " + Arrays.asList(pjp.getArgs()));
//			result = pjp.proceed();
//			//返回通知
//			System.out.println("The method " + methodName + " ends with " + result);
//		} catch (Throwable e) {
//			//异常通知
//			System.out.println("The method " + methodName + " occured exception:" + e);
//		}
//		//后置通知
//		System.out.println("The method " + methodName + " ends");
//		
//		return result;
//	}
}
