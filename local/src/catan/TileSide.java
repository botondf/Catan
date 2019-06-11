package catan;

public class TileSide {
	private Tile tile;
	private Side side;
	
	public TileSide(Side side, Tile tile) {
		super();
		this.tile = tile;
		this.side = side;
	}
	public Tile getTile() {
		return tile;
	}
	public Side getSide() {
		return side;
	}
	
	@Override
	public String toString() {
		return "TileSide [tile=" + tile + ", side=" + side + "]";
	}
}
