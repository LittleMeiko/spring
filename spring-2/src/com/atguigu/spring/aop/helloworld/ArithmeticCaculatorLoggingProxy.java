package com.atguigu.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.KeyStore.Entry;
import java.util.Arrays;

/**
 * ��̬����
 * 
 * @author Meiko
 *
 */
public class ArithmeticCaculatorLoggingProxy {
	
	//������Ķ���
	private ArithmeticCaculator target;
	
	public ArithmeticCaculatorLoggingProxy(ArithmeticCaculator target) {
		super();
		this.target = target;
	}
	
	public ArithmeticCaculator getLoggingProxy() {
		ArithmeticCaculator proxy = null;
		
		//�����������һ����������������
		ClassLoader loader = target.getClass().getClassLoader();
		//�����������ͣ�����������Щ����
		Class[] interfaces = new Class[] {ArithmeticCaculator.class};
		//�����ô���������еķ�����Ӧ��ִ�еĴ���
		InvocationHandler h = new InvocationHandler() {	
			/**
			 * proxy:���ڱ����ص��Ǹ��������
			 * method:���ڱ����õķ���
			 * args:���÷���ʱ����Ĳ���
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object result = null;
				String methodName = method.getName();
				try {
					//ǰ��֪ͨ
					System.out.println("Atguigu->The method " + methodName + " begins with " + Arrays.asList(args));
					result = method.invoke(target, args);
					//����֪ͨ
					System.out.println("Atguigu->The method " + methodName + " ends with " + result);
				} catch (Exception e) {
					//�쳣֪ͨ
					System.out.println("The method " + methodName + " occured exception:" + e);
				}
				//����֪ͨ
				System.out.println("The method " + methodName + " ends");
								
				return result;
			}
		};
		proxy = (ArithmeticCaculator)Proxy.newProxyInstance(loader, interfaces, h);
			
		return proxy;
	}

}
