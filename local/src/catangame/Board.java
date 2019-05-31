package catangame;

import java.util.*;

import catangame.Tile.*;

/**
 * Handles, holds, finds, Tiles and their positions (x,y) & board-wise. Does initial board generation. Also creates the harbours
 *
 */
public class Board {
	private final int[] VALUES = {5, 2, 6, 3, 8, 10, 9, 12, 11, 4, 7, 8, 10, 9, 4, 5, 6, 3, 11};
	public Tile[] boardTiles = new Tile[19]; // total 19 tiles
	public List<Tile> selectedTiles;
	//Player[] players;
	
	Board() {
		// Generate new randomized board
		generateNewTileSet();		
				//	Create Tile
				//		Set values to Tile
				//		*Determine (X,Y) co-ords of each tile for drawing
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int x = 0; x < boardTiles.length; x++) {
			s += "\n" + boardTiles[x].toString();
		}
		return "Tiles of board: " + s;
	}

	public Tile getTileWithId(int id) { // find tile(s) based on the roll
		return boardTiles[id];
		// id = index
	}
	
	public Tile getTileWithValue() { // find tile(s) based on the roll
		Tile t = null;
		
		for (Tile x : boardTiles) {
			t = (x.value == Logic.roll) ? x : null;
		}
		
		return t;
		// id = index
	}
	
	public Tile[] getNeighbourTilesWithPosition(Place pos) { // array or list // position/junction
		return null;
	}
	
	public void generateNewValuesSet() {
		
	}
	
	public void shuffle() {
		Random rgen = new Random(); // Random number generator
		Tile[] boardTilesClone = boardTiles;
		for (int i = 0; i < boardTilesClone.length; i++) {
			int randomPosition = rgen.nextInt(boardTilesClone.length);
			Tile temp = boardTilesClone[i];
			boardTilesClone[i] = boardTilesClone[randomPosition];
			boardTilesClone[randomPosition] = temp;
		}
		boardTiles = boardTilesClone;
	}
	
	public void generateNewTileSet() {
		for (int i = 0; i < boardTiles.length; i++) {
			if (i == 0) {
				boardTiles[i] = new Tile(TileType.DESERT, 0);	// 1 desert
			} else if (i >= 1 && i <= 4) {
				boardTiles[i] = new Tile(TileType.PASTURE, 0);	// 4 pastures
			} else if (i >= 5 && i <= 8) {
				boardTiles[i] = new Tile(TileType.FOREST, 0);	// 4 forests
			} else if (i >= 9 && i <= 11) {
				boardTiles[i] = new Tile(TileType.HILL, 0);		// 3 hills
			} else if (i >= 12 && i <= 14) {
				boardTiles[i] = new Tile(TileType.MOUNTAIN, 0);	// 3 mts
			} else if (i >= 15 && i <= 18) {
				boardTiles[i] = new Tile(TileType.FIELD, 0);	// 4 fields
			}
		}
		shuffle(); // shuffle tiles to randomize board
		for (int v = 0; v < VALUES.length; v++) {
			boardTiles[v].setValue(VALUES[v]);	// tile value is set by VALUES
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Board().toString());
	}
}