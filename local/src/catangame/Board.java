package catangame;

import java.util.*;

import catangame.Tile.*;

/**
 * Handles, holds, finds, Tiles and their positions (x,y) & board-wise. Does initial board generation. Also creates the harbours
 *
 */
public class Board {
	Tile[] tiles = new Tile[18]; // total 19 tiles
	//Player[] players;
	
	@Override
	public String toString() {
		return "";//"Board [tiles=" + Arrays.toString(tiles) + "]";
	}

	Board() {
		//tiles[0] = Tile(0, TileType.HILLS, 11, {});
		// Generate new random board
				//	Create Tile
				//		Set values to Tile
				//		*Determine (X,Y) co-ords of each tile for drawing
	}
	
	public Tile getTileWithId(int id) { // find tile(s) based on role
		return tiles[id];
		// id = index
	}
	
	public Tile[] getNeighbourTilesWithPosition(Place pos) { // array or list // position/junction
		return null;
	}
	
	public void generate() {
		
	}
}