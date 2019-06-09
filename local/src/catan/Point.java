package catan;

public class Point {
	private double x;
	private double y;

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
	
	public boolean isPointInArea(Point point, double distance) {
		boolean xTrue;
		boolean yTrue;

		if (point.getX() - distance <= getX() || point.getX() + distance <= getX()) {
			xTrue = true;
		} else if (getX() == point.getX()) {
			xTrue = true;
		} else {
			xTrue = false;
		}

		if (point.getY() - distance <= getY() || point.getY() + distance <= getY()) {
			yTrue = true;
		} else if (getY() == point.getY()) {
			yTrue = true;
		} else {
			yTrue = false;
		}

		return (xTrue && yTrue) ? true : false;
	}
}