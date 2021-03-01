package com.himanshu.SpringMorningAssignment;

import java.util.Map;

public class RectangleWithMap {
	private Map<Integer, Point> map;
	private int height;
	private int width;

	public RectangleWithMap(Map<Integer, Point> map, int height, int width) {
		super();
		this.map = map;
		this.height = height;
		this.width = width;
	}

	public Map<Integer, Point> getMap() {
		return map;
	}

	public void setMap(Map<Integer, Point> map) {
		this.map = map;
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
		return "ReactangleWithMap [map=" + map + ", height=" + height + ", width=" + width + "]";
	}

}
