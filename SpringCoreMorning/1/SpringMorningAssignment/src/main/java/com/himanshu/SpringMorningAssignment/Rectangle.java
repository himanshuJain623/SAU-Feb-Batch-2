package com.himanshu.SpringMorningAssignment;

public class Rectangle {
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private Point pointD;
	private int height;
	private int width;

	public Rectangle() {
		super();
	}

	public Rectangle(Point pointA, Point pointB, Point pointC, Point pointD) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
		this.pointD = pointD;
		this.height = pointB.getY()-pointA.getY();
		this.width = pointD.getX()-pointA.getX();
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public Point getPointD() {
		return pointD;
	}

	public void setPointD(Point pointD) {
		this.pointD = pointD;
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
		return "Rectangle [pointA=" + pointA + ", pointB=" + pointB + ", pointC=" + pointC + ", pointD=" + pointD
				+ ", height=" + height + ", width=" + width + "]";
	}

}
