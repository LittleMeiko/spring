package com.atguigu.spring.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 通过FactoryBean来配置Bean实例
 * 
 * @author Meiko
 *
 */
public class CarFactoryBean implements FactoryBean<Car>{
	
	private String brand;
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public Car getObject() throws Exception {
		return new Car(brand, 500000);
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
	
}
