package catangame;

import java.util.*;

import catangame.Tile.*;

/**
 * Handles, holds, finds, Tiles and their positions (x,y) & board-wise. Does initial board generation. Also creates the harbours
 *
 */
public class Board {
	private final int[] VALUES = {5, 2, 6, 3, 8, 10, 9, 12, 11, 4, 7, 8, 10, 9, 4, 5, 6, 3, 11};
	public Tile[] boardTiles = new Tile[18]; // total 19 tiles
	public List<Tile> selectedTiles;
	//Player[] players;
	
	Board() {
		generateNewTileSet();
		//tiles[0] = Tile(0, TileType.HILLS, 11, {});
		// Generate new random board
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
	
//	private void shuffle() {
//		List<Tile> clone = Arrays.asList(boardTiles);
//		Tile[] danew = new Tile[boardTiles.length];
//		for (int x = 0; x < boardTiles.length; x++) {
//			int r = Logic.randomNumber(0, boardTiles.length-1);
//			danew[x] = clone.get(r);
//			clone.remove(r);
//		}
//		boardTiles = danew;
//			
//	}
	
	public void shuffle() {
		Random rgen = new Random(); // Random number generator
		Tile[] array = boardTiles;
		for (int i = 0; i < array.length; i++) {
			int randomPosition = rgen.nextInt(array.length);
			Tile temp = array[i];
			array[i] = array[randomPosition];
			array[randomPosition] = temp;
		}
		boardTiles = array;
	}
	
	public void generateNewTileSet() {
		for (int id = 0; id < boardTiles.length; id++) {
			boardTiles[id] = new Tile(id, TileType.values()[Logic.randomNumber(0, 5)], VALUES[id]);
		}
		shuffle();
		
	}
	
	public static void main(String[] args) {
		System.out.println(new Board().toString());
	}
}