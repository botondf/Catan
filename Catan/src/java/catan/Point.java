package catan;

public class Point {
	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
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
	/**
	 * compares two points to see if they are nearby by checking if it is a certain radius away
	 * @param otherPoint
	 * @return true if point is nearby, false if no
	 */
	public boolean isPointNearby(Point otherPoint) {
		return isPointNearby(otherPoint, Catan.scale.getPointNearbyRadius());
	}
	
	/**
	 * compares two points to see if they are nearby by checking if it is a certain radius away
	 * @param otherPoint
	 * @param radius
	 * @return true if point is nearby, false if no
	 */
	public boolean isPointNearby(Point otherPoint, double radius) {
		double x1 = getX();
		double y1 = getY();
		double x2 = otherPoint.getX();
		double y2 = otherPoint.getY();

		// Use the Pythagorean theorem to find the distance between the two points
		double distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
		
		boolean inside = (distance <= radius) ? true : false;
		
		return inside;
	}
	
	public Point transform(Point moveTo, double scale) {
		double tx = x * scale + moveTo.getX();
		double ty = y * scale + moveTo.getY();
		return new Point(tx, ty);
	}

}