package catan;

public class TileSide {
	private Tile tile;
	private Side side;

	public TileSide(Side side, Tile tile) {
		super();
		this.tile = tile;
		this.side = side;
	}

	@Override
	public String toString() {
		return "TileSide [tile=" + tile + ", side=" + side + "]";
	}

	public Tile getTile() {
		return tile;
	}

	public Side getSide() {
		return side;
	}

	public boolean isNearby(TileSide other) {
		// All nearby path points of a tile side will have same rotation degree
		// and their center points must be nearby
		return this.getSide().getCentre().isPointNearby(other.getSide().getCentre());
	}


}
