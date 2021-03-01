package com.himanshu.SpringMorningAssignment;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class RectangleWithList {
	
	private List<Point> points;
	private int height;
	private int width;
	
	public RectangleWithList() {
		super();
	}
	
	public RectangleWithList(List<Point> points, int height, int width) {
		super();
		this.points = points;
		this.height = height;
		this.width = width;
	}

	public List<Point> getPoints() {
		return points;
	}
	
	public void setPoints(List<Point> points) {
		this.points = points;	
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "RectangleWithList [points=" + points + ", height=" + height + ", width=" + width + "]";
	}
		
	
}
