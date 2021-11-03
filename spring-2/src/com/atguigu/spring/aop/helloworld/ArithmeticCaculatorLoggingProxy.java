package com.atguigu.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 动态代理
 * 
 * @author Meiko
 *
 */
public class ArithmeticCaculatorLoggingProxy {
	
	//被代理的对象
	private ArithmeticCaculator target;
	
	public ArithmeticCaculatorLoggingProxy(ArithmeticCaculator target) {
		super();
		this.target = target;
	}
	
	public ArithmeticCaculator getLoggingProxy() {
		ArithmeticCaculator proxy = null;
		
		//代理对象由哪一个类加载器负责加载
		ClassLoader loader = target.getClass().getClassLoader();
		//代理对象的类型，即其中有哪些方法
		Class[] interfaces = new Class[] {ArithmeticCaculator.class};
		//当调用代理对象其中的方法，应该执行的代码
		InvocationHandler h = new InvocationHandler() {	
			/**
			 * proxy:正在被返回的那个代理对象
			 * method:正在被调用的方法
			 * args:调用方法时传入的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				System.out.println("Atguigu->The method " + methodName + " begins with " + Arrays.asList(args));
				Object result = method.invoke(target, args);
				System.out.println("Atguigu->The method " + methodName + " ends with " + result);
				return result;
			}
		};
		proxy = (ArithmeticCaculator)Proxy.newProxyInstance(loader, interfaces, h);
			
		return proxy;
	}

}
