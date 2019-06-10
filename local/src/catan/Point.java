package catan;

import java.lang.Math.*;

public class Point {
	private double x;
	private double y;
	private static final double POINT_NEARBY_RADIUS = 10;//Board.EDGE - TileGraphics.TRANSFORMATION;


	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public boolean isPointNearby(Point otherPoint) {
		double x1 = getX();
		double y1 = getY();
		double x2 = otherPoint.getX();
		double y2 = otherPoint.getY();

		double distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
		
		boolean inside = (distance <= POINT_NEARBY_RADIUS) ? true : false;
		
		return (inside) ? true : false;
	}
}