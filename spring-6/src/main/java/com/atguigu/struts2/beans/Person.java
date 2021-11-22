package com.atguigu.struts2.beans;

public class Person {
	
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void hello() {
		System.out.println("My name is " + name);
	}
}
