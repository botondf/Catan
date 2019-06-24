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
		
	public Point getVerticePointAt(int arrayPos) {
		double x = VERTICES[arrayPos][0]; //x
		double y = VERTICES[arrayPos][1]; //y
		
		return new Point(x, y).transform(centre, TileGraphics.TRANSFORMATION);
	}
	
	public Side getSideAt(int arrayPos) {
		double ax = VERTICES[arrayPos][0];
		double ay = VERTICES[arrayPos][1];
		
		int nextPos;
		if(arrayPos == 5) {
			nextPos = 0;
		} else {
			nextPos = arrayPos + 1;
		}

		double bx = VERTICES[nextPos][0];
		double by = VERTICES[nextPos][1];

		Point a = new Point(ax, ay).transform(centre, TileGraphics.TRANSFORMATION);
		Point b = new Point(bx, by).transform(centre, TileGraphics.TRANSFORMATION);
		
		return new Side(a, b);
	}

}