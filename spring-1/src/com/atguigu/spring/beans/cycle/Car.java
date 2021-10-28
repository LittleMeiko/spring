package com.atguigu.spring.beans.cycle;

public class Car {
	
	private String brand;
	
	public Car() {
		System.out.println("Car's Constructor");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println("Car's set()...");
		this.brand = brand;
	}
	
	public void init() {
		System.out.println("Car's init...");
	}
	
	public void destory() {
		System.out.println("Car's destory...");
	}
}
