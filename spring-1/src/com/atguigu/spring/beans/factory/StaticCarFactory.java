package com.atguigu.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法配置bean
 * 
 * @author Meiko
 *
 */
public class StaticCarFactory {
	
	private static Map<String, Car> cars = new HashMap<String, Car>();
	
	static {
		cars.put("Audi", new Car("Audi", 300000));
		cars.put("Ford", new Car("Ford", 400000));
	}
	
	public static Car getCar(String brand) {
		return cars.get(brand);
	}
	
}	
