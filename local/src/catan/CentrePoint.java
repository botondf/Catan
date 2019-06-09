package catan;

public class CentrePoint {
	private static final double[][] VERTICES = {
			{0.5, 0.866}, 
			{1, 0}, 
			{0.5, -0.866},
			{-0.5, -0.866},
			{-1, 0},
			{-0.5, 0.866}
	};
	
	private Point center;

	CentrePoint(Point point) {
		this.center = point;
	}

	CentrePoint(double x, double y) {
		this.center = new Point(x, y);
	}

	@Override
	public String toString() {
		return "CentrePoint [point=" + center + "]";
	}

	public Point getPoint() {
		return center;
	}

	public void setPoint(Point point) {
		this.center = point;
	}
	
	public Point getPointAt(int arrayPos) {
		double x = VERTICES[arrayPos][0]; //x
		double y = VERTICES[arrayPos][1]; //y
		
		return transformPoint(x, y);
	}
	public Point transformPoint(double x, double y) {
		double tx = x * TileGraphics.K + center.getX();
		double ty = y * TileGraphics.K + center.getY();
		return new Point(tx, ty);
	}

}