package com.himanshu.SpringMorningAssignment;

import java.util.Set;

public class RectangleWithSet {
	private Set<Point> set;
	private int height;
	private int width;

	public RectangleWithSet(Set<Point> set, int height, int width) {
		super();
		this.set = set;
		this.height = height;
		this.width = width;
	}

	public Set<Point> getSet() {
		return set;
	}

	public void setSet(Set<Point> set) {
		this.set = set;
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
		return "ReactangleWithSet [set=" + set + ", height=" + height + ", width=" + width + "]";
	}

}
