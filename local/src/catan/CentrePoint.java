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
	
	private Point centre;

	CentrePoint(Point point) {
		this.centre = point;
	}

	CentrePoint(double x, double y) {
		this.centre = new Point(x, y);
	}

	@Override
	public String toString() {
		return "CentrePoint [point=" + centre + "]";
	}

	public Point getPoint() {
		return centre;
	}

	public void setPoint(Point point) {
		this.centre = point;
	}
		
	public Point getPointAt(int arrayPos) {
		double x = VERTICES[arrayPos][0]; //x
		double y = VERTICES[arrayPos][1]; //y
		
		return transformPoint(x, y);
	}
	public Point transformPoint(double x, double y) {
		double tx = x * TileGraphics.TRANSFORMATION + centre.getX();
		double ty = y * TileGraphics.TRANSFORMATION + centre.getY();
		return new Point(tx, ty);
	}

}