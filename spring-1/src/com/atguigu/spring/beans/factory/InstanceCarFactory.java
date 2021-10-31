package com.atguigu.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂方法配置bean
 * 
 * @author Meiko
 *
 */
public class InstanceCarFactory {
	
	private static Map<String, Car> cars = null;
	
	public InstanceCarFactory() {
		cars = new HashMap<String, Car>();
		cars.put("Audi", new Car("Audi", 300000));
		cars.put("Ford", new Car("Ford", 400000));
	}
	
	public Car getCar(String brand) {
		return cars.get(brand);
	}
}
