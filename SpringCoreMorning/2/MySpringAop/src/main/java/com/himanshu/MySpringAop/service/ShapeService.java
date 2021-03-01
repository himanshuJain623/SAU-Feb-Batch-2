package com.himanshu.MySpringAop.service;

import com.himanshu.MySpringAop.model.Circle;
import com.himanshu.MySpringAop.model.Triangle;

public class ShapeService {
	private Circle circle;
	private Triangle triangle;

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public Triangle getTriangle() {
		return triangle;
	}

	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	
	public int throwException() throws ArithmeticException{
		return 1/0;
	}
	
	public String sayGreeting(String greet) {
		return greet;
	}
}
