package com.himanshu.MySpringAop.model;

public class Circle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getInfo() {
		return "You have called a circle";
	}
}
