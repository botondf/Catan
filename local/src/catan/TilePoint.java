package catan;

public class TilePoint {

	private Point point;
	private Tile tile;
	
	public TilePoint(Point point, Tile tile) {
		this.point = point;
		this.tile = tile;
	}

	@Override
	public String toString() {
		return "TilePoint [point=" + point + ", tile=" + tile + "]";
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}
}
