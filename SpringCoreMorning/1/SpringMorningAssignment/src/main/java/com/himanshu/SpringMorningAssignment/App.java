package com.himanshu.SpringMorningAssignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(config.class);

		// using individual objects
		Rectangle rect = ctx.getBean(Rectangle.class);
		System.out.println(rect);

		// using list collection
		RectangleWithList rect1 = ctx.getBean(RectangleWithList.class);
		System.out.println(rect1);

		// using map collection
		RectangleWithMap rect2 = ctx.getBean(RectangleWithMap.class);
		System.out.println(rect2);

		// using set collection
		RectangleWithSet rect3 = ctx.getBean(RectangleWithSet.class);
		System.out.println(rect3);

	}
}
