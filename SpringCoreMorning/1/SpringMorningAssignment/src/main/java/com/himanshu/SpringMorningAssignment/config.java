package com.himanshu.SpringMorningAssignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.*;

@Configuration
public class config {

	// using individual objects
	@Bean
	public Rectangle rectangle() {
		return new Rectangle(pointA(), pointB(), pointC(), pointD());
	}

	// using list collection
	@Bean
	public RectangleWithList rectangleList() {
		Point A=pointA();
		Point B=pointB();
		Point C=pointC();
		Point D=pointD();
		List<Point> list = new ArrayList<Point>(Arrays.asList(A, B, C, D));
		int h = B.getY() - A.getY();
		int w = D.getX() - A.getX();
		return new RectangleWithList(list, h, w);
	}

	// using map collection
	@Bean
	public RectangleWithMap rectangleMap() {
		Point A=pointA();
		Point B=pointB();
		Point C=pointC();
		Point D=pointD();
		Map<Integer, Point> map = new HashMap();
		map.put(1, A);
		map.put(2, B);
		map.put(3, C);
		map.put(4, D);
		int h = B.getY() - A.getY();
		int w = D.getX() - A.getX();
		return new RectangleWithMap(map, h, w);
	}

	// using set collection
	@Bean
	public RectangleWithSet rectangleSet() {
		Point A=pointA();
		Point B=pointB();
		Point C=pointC();
		Point D=pointD();
		Set<Point> set = new HashSet<Point>();
		set.add(A);
		set.add(B);
		set.add(C);
		set.add(D);
		int h = B.getY() - A.getY();
		int w = D.getX() - A.getX();
		return new RectangleWithSet(set, h, w);
	}

	@Bean
	public Point pointA() {
		return new Point(0, 0);
	}

	@Bean
	public Point pointB() {
		return new Point(0, 10);
	}

	@Bean
	public Point pointC() {
		return new Point(20, 10);
	}

	@Bean
	public Point pointD() {
		return new Point(20, 0);
	}

}
