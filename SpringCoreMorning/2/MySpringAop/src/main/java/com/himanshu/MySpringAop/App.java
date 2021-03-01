package com.himanshu.MySpringAop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.himanshu.MySpringAop.model.Circle;
import com.himanshu.MySpringAop.model.Triangle;
import com.himanshu.MySpringAop.service.ShapeService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");

		ShapeService shapeService = ctx.getBean("shapeservice", ShapeService.class);
//		Circle circle = ctx.getBean("circle", Circle.class);
//		Triangle triangle = ctx.getBean("triangle", Triangle.class);

		System.out.println("------------CALLING SHAPESERVICE --------------");
//		System.out.println(shapeService.getCircle().getName());
//		System.out.println(shapeService.getTriangle().getName());
//		
//		try {
//			System.out.println(shapeService.throwException());
//		} catch (Exception e) {
//
//		}
		
		System.out.println(shapeService.sayGreeting("hello"));
		
//		System.out.println("------------CALLING CIRCLE --------------");
//		System.out.println(circle.getInfo());
//		System.out.println(circle.getName());
//		
//		System.out.println("------------CALLING TRIANGLEE GETTERS--------------");
//		System.out.println(triangle.getName());
		
	}
}
