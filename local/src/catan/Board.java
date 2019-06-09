package catan;

import java.util.List;
import java.util.ArrayList;
import javafx.scene.shape.Shape;

/**
 * Handles, holds, finds, Tiles and their positions (x,y) & board-wise. Does
 * initial board generation. Also creates the harbours
 * @
 */
public class Board {
	private static final int[] VALUES = { 5, 2, 6, 3, 8, 10, 9, 12, 11, 4, 7, 8, 10, 9, 4, 5, 6, 3, 11 };
	private static final double EDGE = 105.0	;
	public Tile[] boardTiles = new Tile[19]; // total 19 tiles
	public List<Tile> selectedTiles;
	public List<Intersection> intersections = new ArrayList<>();
	public CentrePoint[] centrePoints = new CentrePoint[19];
	
	public Board() { }
	
	@Override
	public String toString() {
		String s = "";
		for (int x = 0; x < boardTiles.length; x++) {
			s += "\n" + (x + 1) + ": " + boardTiles[x].toString();
		}
		return "Tiles of board: " + s;
	}

	public static Board newBoardWithTiles() {
		Board board = new Board();
		board.generateNewTileSet();
		return board;
	}

	private void tessellation() {
		double x = Main.SCREEN_WIDTH / 2;
		double y = Main.SCREEN_HEIGHT / 2;
		//double edge = 105; // length of one edge of hex
		double length = (Math.sqrt(3) * EDGE) + 1;
		double a = length * Math.cos(Math.toRadians(60));
		double b = length * Math.cos(Math.toRadians(30));
		double c1 = 3 * EDGE * Math.tan(Math.toRadians(30));
		double c2 =  1.5 * EDGE * Math.tan(Math.toRadians(60));

		// setting centre (position) of each tile pos counter-clockwise from middle tile based on base x, y		
		centrePoints[0] = new CentrePoint(x, y);
		centrePoints[1] = new CentrePoint(x - b, y - a);
		centrePoints[2] = new CentrePoint(x, y - length);
		centrePoints[3] = new CentrePoint(x + b, y - a);
		centrePoints[4] = new CentrePoint(x + b, y + a);
		centrePoints[5] = new CentrePoint(x, y + length);
		centrePoints[6] = new CentrePoint(x - b, y + a);
		centrePoints[7] = new CentrePoint(x - 3 * EDGE, y);
		centrePoints[8] = new CentrePoint(x - 3 * EDGE, y - c1);
		centrePoints[9] = new CentrePoint(x - 1.5 * EDGE, y - c2);
		centrePoints[10] = new CentrePoint(x, y - 2 * length);
		centrePoints[11] = new CentrePoint(x + 1.5 * EDGE, y - c2);
		centrePoints[12] = new CentrePoint(x + 3 * EDGE, y - c1);
		centrePoints[13] = new CentrePoint(x + 3 * EDGE, y);
		centrePoints[14] = new CentrePoint(x + 3 * EDGE, y + c1);
		centrePoints[15] = new CentrePoint(x + 1.5 * EDGE, y + c2);
		centrePoints[16] = new CentrePoint(x, y + 2 * length);
		centrePoints[17] = new CentrePoint(x - 1.5 * EDGE, y + c2);
		centrePoints[18] = new CentrePoint(x - 3 * EDGE, y + c1);
		
		for(int i = 0; i < centrePoints.length; i++) {
			boardTiles[i].getTileGraphics().setCentre(centrePoints[i]);
			for (int j = 0; j < 6; j++) {
				CentrePoint centre = centrePoints[j];
				Point point = centre.getPointAt(j);
				Intersection inters = new Intersection(point);
				intersections.add(inters);
			}
		}
		
		
		System.out.println(intersections.toString());
	
	}

	public Tile getTileWithId(int id) { // find tile(s) based on the place in board array
		return boardTiles[id];
	}

	public void getTilesWithValue(int value) { // find tile(s) based on the roll
		List<Tile> tileList = new ArrayList<Tile>();

		for (int x = 0; x < boardTiles.length; x++) {
			if (boardTiles[x].rollValue == value) {
				tileList.add(boardTiles[x]);
			}
		}

		selectedTiles = tileList;
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
				boardTiles[i] = new Tile(TileType.PASTURE, 0, new ArrayList<Building>()); // 4 pastures
			} else if (i >= 4 && i <= 6) {
				boardTiles[i] = new Tile(TileType.HILL, 0, new ArrayList<Building>()); // 3 hills
			} else if (i >= 7 && i <= 9) {
				boardTiles[i] = new Tile(TileType.MOUNTAIN, 0, new ArrayList<Building>()); // 3 mountains
			} else if (i == 10) {
				boardTiles[i] = new Tile(TileType.DESERT, 0, new ArrayList<Building>()); // 1 desert (will always have value 7)
			} else if (i >= 11 && i <= 14) {
				boardTiles[i] = new Tile(TileType.FOREST, 0, new ArrayList<Building>()); // 4 forests
			} else if (i >= 15 && i <= 18) {
				boardTiles[i] = new Tile(TileType.FIELD, 0, new ArrayList<Building>()); // 4 fields
			}
		}

		shuffle(); // shuffle tiles to randomize board

		for (int v = 0; v < VALUES.length; v++) {
			boardTiles[v].setRollValue(VALUES[v]); // tile value is set by VALUES
		}
	}

	public List<Shape> buildTileShapes() {

		tessellation();

		List<Shape> shapes = new ArrayList<Shape>();

		for (Tile tile : this.boardTiles) {
			TileGraphics hexagon = tile.getTileGraphics();

			shapes.addAll(hexagon.makeShapes());
		}

		return shapes;
	}
}