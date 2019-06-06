package catan;

import catan.BoardUI;
import java.util.*;

import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
//import catangame.Tile.*;
import javafx.scene.shape.*;
import javafx.stage.Screen;

/**
 * Handles, holds, finds, Tiles and their positions (x,y) & board-wise. Does initial board generation. Also creates the harbours
 *
 */
public class Board {
	private Screen screen = Screen.getPrimary();
	private Rectangle2D bounds = screen.getVisualBounds();
	
	private final double SCREEN_WIDTH = 1920;//bounds.getWidth();
	private final double SCREEN_HEIGHT = 1080;//bounds.getHeight();
	
	private final int[] VALUES = {5, 2, 6, 3, 8, 10, 9, 12, 11, 4, 7, 8, 10, 9, 4, 5, 6, 3, 11};
	public Tile[] boardTiles = new Tile[19]; // total 19 tiles
	public List<Tile> selectedTiles;
	//private Circle[] markers = new Circle[19];
	
	
	//Player[] players;
	
	Board() {
		// Generate new randomized board
		generateNewTileSet();
		generateBoardUI();
				//	Create Tile
				//		Set values to Tile
				//		*Determine (X,Y) co-ords of each tile for drawing
	}
	
	public void generateBoardUI() {
		double x = SCREEN_WIDTH / 2;
		double y = SCREEN_HEIGHT / 2;
		double edge = 99.5; // edge
		double length = (int) (Math.sqrt(3) * edge) + 1;
		int a = (int) (length * Math.cos(Math.toRadians(60)));
		int b = (int) (length * Math.cos(Math.toRadians(30)));
		int c1 = (int) (3 * edge * Math.tan(Math.toRadians(30)));
		int c2 = (int) (1.5 * edge * Math.tan(Math.toRadians(60)));

		// setting centre of each tile pos counter-clockwise from middle tile based on base x, y
		boardTiles[0].setPosition(x, y);
		boardTiles[1].setPosition(x - b, y - a);
		boardTiles[2].setPosition(x, y - length);
		boardTiles[3].setPosition(x + b, y - a);
		boardTiles[4].setPosition(x + b, y + a);
		boardTiles[5].setPosition(x, y + length);
		boardTiles[6].setPosition(x - b, y + a);

		boardTiles[7].setPosition(x - 3 * edge, y);
		boardTiles[8].setPosition(x - 3 * edge, y - c1);
		boardTiles[9].setPosition(x - 1.5 * edge, y - c2);
		boardTiles[10].setPosition(x, y - 2 * length);
		boardTiles[11].setPosition(x + 1.5 * edge, y - c2);
		boardTiles[12].setPosition(x + 3 * edge, y - c1);
		boardTiles[13].setPosition(x + 3 * edge, y);
		boardTiles[14].setPosition(x + 3 * edge, y + c1);
		boardTiles[15].setPosition(x + 1.5 * edge, y + c2);
		boardTiles[16].setPosition(x, y + 2 * length);
		boardTiles[17].setPosition(x - 1.5 * edge, y + c2);
		boardTiles[18].setPosition(x - 3 * edge, y + c1);
		//return board;
	}
	
	public void makeShapes() {
		for (Tile tile : boardTiles) {
			tile.setShape(new Hexagon(tile.x, tile.y, tile.value));
		}
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int x = 0; x < boardTiles.length; x++) {
			s += "\n" + (x+1) + ": " + boardTiles[x].toString();
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
				boardTiles[i] = new Tile(TileType.FOREST, 0, new ArrayList<Building>());	// 4 forests
			} else if (i >= 15 && i <= 18) {
				boardTiles[i] = new Tile(TileType.FIELD, 0, new ArrayList<Building>());	// 4 fields
			}
		}
		shuffle(); // shuffle tiles to randomize board
		for (int v = 0; v < VALUES.length; v++) {
				boardTiles[v].setValue(VALUES[v]);	// tile value is set by VALUES
			}
		}
	
	public static void main(String[] args) {
		Board board = new Board();
		System.out.println(board.SCREEN_WIDTH+ "\n" + board.SCREEN_HEIGHT);
	}
}