package catan;

import java.util.*;
//import catangame.Tile.*;
import javafx.scene.shape.*;

/**
 * Handles, holds, finds, Tiles and their positions (x,y) & board-wise. Does initial board generation. Also creates the harbours
 *
 */
public class Board {
	private final int[] VALUES = {5, 2, 6, 3, 8, 10, 9, 12, 11, 4, 7, 8, 10, 9, 4, 5, 6, 3, 11};
	public Tile[] boardTiles = new Tile[19]; // total 19 tiles
	public List<Tile> selectedTiles;
	private Circle[] markers = new Circle[19];
	
	
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
			s += "\n1: " + boardTiles[x].toString();
		}
		return "Tiles of board: " + s;
	}

	public Tile getTileWithId(int id) { // find tile(s) based on the roll
		return boardTiles[id];
		// id = index
	}
	
	public List<Tile> getTilesWithValue(int value) { // find tile(s) based on the roll
		List<Tile> tileList = new ArrayList<Tile>();
		
		for (int x = 0; x < boardTiles.length; x++) {
			if (boardTiles[x].value == value) {
				tileList.add(boardTiles[x]);
			}
		}
		
		return tileList;
		// id = index
	}
	
	public Tile[] getNeighbourTilesWithPosition(Place pos) { // array or list // position/junction
		return null;
	}
	
	public void shuffle() {		
		Tile[] boardTilesClone = boardTiles;
		
		// to ensure desert/robber is index 10 (and thus value 7), exclude it from shuffle
		// boardTiles indices 0 - 10
		for (int i = 0; i < 10; i++) {
			int randomPosition = Logic.randomNumber(0, 9);
			Tile temp = boardTilesClone[i];
			boardTilesClone[i] = boardTilesClone[randomPosition];
			boardTilesClone[randomPosition] = temp;
		}
		
		// indices 11 - 18
		for (int i = 11; i < 18; i++) {
			int randomPosition = Logic.randomNumber(11, 18);
			Tile temp = boardTilesClone[i];
			boardTilesClone[i] = boardTilesClone[randomPosition];
			boardTilesClone[randomPosition] = temp;
		}
		boardTiles = boardTilesClone;
	}
	
	public void generateNewTileSet() {
		for (int i = 0; i < boardTiles.length; i++) {
			if (i >= 0 && i <= 3) {
				boardTiles[i] = new Tile(TileType.PASTURE, 0, new ArrayList<Building>());	// 4 pastures
			} else if (i >= 4 && i <= 6) {
				boardTiles[i] = new Tile(TileType.HILL, 0, new ArrayList<Building>());	// 3 hills
			} else if (i >= 7 && i <= 9) {
				boardTiles[i] = new Tile(TileType.MOUNTAIN, 0, new ArrayList<Building>());	// 3 mountains  
			} else if (i == 10) {
				boardTiles[i] = new Tile(TileType.DESERT, 0, new ArrayList<Building>());	// 1 desert (will always have value 7)
			} else if (i >= 11 && i <= 14) {
				boardTiles[i] = new Tile(TileType.MOUNTAIN, 0, new ArrayList<Building>());	// 4 forests
			} else if (i >= 15 && i <= 18) {
				boardTiles[i] = new Tile(TileType.FIELD, 0, new ArrayList<Building>());	// 4 fields
			}
		}
		shuffle(); // shuffle tiles to randomize board
		for (int v = 0; v < VALUES.length; v++) {
				boardTiles[v].setValue(VALUES[v]);	// tile value is set by VALUES
			}
		}
}