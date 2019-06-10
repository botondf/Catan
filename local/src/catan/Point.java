package catan;

public class Point {
	private double x;
	private double y;
	private static final double POINT_NEARBY_RANGE = 10;//Board.EDGE - TileGraphics.TRANSFORMATION;


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
	
	public boolean isPointNearby(Point point) {
		boolean xTrue;
		boolean yTrue;

		if (point.getX() - POINT_NEARBY_RANGE <= getX() || point.getX() + POINT_NEARBY_RANGE <= getX()) {
			xTrue = true;
		} else if (getX() == point.getX()) {
			xTrue = true;
		} else {
			xTrue = false;
		}

		if (point.getY() - POINT_NEARBY_RANGE <= getY() || point.getY() + POINT_NEARBY_RANGE <= getY()) {
			yTrue = true;
		} else if (getY() == point.getY()) {
			yTrue = true;
		} else {
			yTrue = false;
		}

		return (xTrue && yTrue) ? true : false;
	}
}