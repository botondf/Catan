package catan;

public class Side {
	private Point a;
	private Point b;
	private Point centre;
	
	public Side(Point a, Point b) {
		this.a = a;
		this.b = b;
		
		double x = ( a.getX() + b.getX() ) / 2.0;
		double y = ( a.getY() + b.getY() ) / 2.0;
		this.centre = new Point(x,y);
	}

	public Point getPointA() {
		return a;
	}
	
	public Point getPointB() {
		return b;
	}
	
	public Point getCentre() {
		return centre;
	}
}
