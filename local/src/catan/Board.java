package catan;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Handles, holds, finds, Tiles and their positions (x,y) & board-wise. Does
 * initial board generation. Also creates the places for tiles
 * @
 */
public class Board {
	private static final int[] VALUES = { 5, 2, 6, 3, 8, 10, 9, 12, 11, 4, 7, 8, 10, 9, 4, 5, 6, 3, 11 };
	public static final double EDGE = 105.0	;
	public Tile[] boardTiles = new Tile[19]; // total 19 tiles
	public List<Tile> rollSelectedTiles;
	public List<Intersection> intersections = new ArrayList<>();
	public List<Path> paths = new ArrayList<>();
	public List<Place> places = new ArrayList<>();
	public CentrePoint[] centrePoints = new CentrePoint[19];
	
	public Board() {
		tessellation();
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int x = 0; x < boardTiles.length; x++) {
			s += "\n" + (x + 1) + ": " + boardTiles[x].toString();
		}
		return "Tiles of board: " + s;
	}
	
	/**
	 * Initialize a new board with newly generated randomized tiles
	 */
	public static Board newBoardWithTiles() {
		Board board = new Board();
		board.generateNewTileSet();
		return board;
	}

	/**
	 * Find the tiles
	 * @param value
	 * @return List of tiles
	 */
	public List<Tile> getTilesWithValue(int value) { // find tile(s) based on the roll
		List<Tile> tileList = new ArrayList<Tile>();

		for (int x = 0; x < boardTiles.length; x++) {
			if (boardTiles[x].rollValue == value) {
				tileList.add(boardTiles[x]);
			}
		}
		return tileList;
	}
	
	/**
	 * gets the desert tile
	 * @return desert Tile
	 */
	public Tile getDesert() {
		Tile desert = null;
		for (int x = 0; x < boardTiles.length; x++) {
			if (boardTiles[x].getType() == TileType.DESERT) {
				desert = boardTiles[x];
				Objects.requireNonNull(desert, "robber");
			}
		}
		return desert;
	}
	
	/**
	 * @param tile The tile which boardTiles array position is to be determined
	 * @return int boardTiles array position
	 */
	public int getTileArrayPos(Tile tile) {
		int pos = 0;
		
		for (int t = 0; t < boardTiles.length; t++) {
			if (tile.equals(boardTiles[t])) {
				pos = t;
			}
		}
		
		return pos;
	}

	/**
	 * Sets the tessellated CentrePoints of the board based on screen size and tile edge.
	 */
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
	}
	/**
	 * Set the TileGraphics at each CentrePoint for each Tile of the board's CentrePoints
	 */
	private void makeTileGraphics() {
		
		for (int i = 0; i < centrePoints.length; i++) {
			
			Tile tile = boardTiles[i];
			CentrePoint centrePoint = centrePoints[i];
			
			// Make a new tile graphic obj with the tile
			TileGraphics tgfx = new TileGraphics(tile);
			tgfx.setCentre(centrePoint);
			tile.setTileGraphics(tgfx);
		}
	}
	
	private void makePlaceGraphics() {
		List<TilePoint> tileVertexPoints = new ArrayList<>();
		List<TileSide> tileEdgePoints = new ArrayList<>();
			
		for (Tile tile : boardTiles) {
			
			CentrePoint centrePoint = tile.getTileGraphics().getCentre();
			
			for (int j = 0; j < 6; j++) {
				Point point = centrePoint.getVerticePointAt(j);
				tileVertexPoints.add(new TilePoint(point, tile));
			}
			
			for (int j = 0; j < 6; j++) {
				Side side = centrePoint.getSideAt(j);
				tileEdgePoints.add(new TileSide(side, tile));
			}
		}
		
		// PATHS
		for (int i = 0; i < tileEdgePoints.size(); i++) {
			
			TileSide point = tileEdgePoints.get(i);
			List<TileSide> nearbyPoints = new ArrayList<>();
			
			for (int j = 0; j < tileEdgePoints.size(); j++) {
				
				TileSide otherPoint = tileEdgePoints.get(j);
				
				if (point.getSide().getCentre().isPointNearby(otherPoint.getSide().getCentre())) {
					nearbyPoints.add(otherPoint);
				}
			}
			
			if (nearbyPoints.isEmpty()) {
				throw new RuntimeException("no nearby points found");
			}
		
			double sumX = 0;
			double sumY = 0;
			
			for (TileSide nearbyPoint : nearbyPoints) {
				sumX += nearbyPoint.getSide().getCentre().getX();
				sumY += nearbyPoint.getSide().getCentre().getY();
			}
			
			double averageX = sumX / (double) (nearbyPoints.size());
			double averageY = sumY / (double) (nearbyPoints.size());
			
			Point pathPoint = new Point(averageX, averageY);
			
			Path path = new Path(pathPoint);
		
			for (TileSide nearbyPoint : nearbyPoints) {
				Tile tile = nearbyPoint.getTile();
				tile.getPlaces().add(path);
				path.addTile(tile);
			}
						
			Circle circle = new Circle();
			circle.setRadius(TileGraphics.PLACE_CIRCLE_RADIUS);
			circle.setCenterX(pathPoint.getX());
			circle.setCenterY(pathPoint.getY());
			circle.setFill(Color.WHITE);
//			circle.setVisible(false);
			circle.setStroke(Color.BLACK);
			circle.setOnMouseClicked((event) -> System.out.println(path));

			path.setShape(circle);

			paths.add(path);
		}
		
		// INTERSECTIONS
		for (int i = 0; i < tileVertexPoints.size(); i++) {
			
			TilePoint point = tileVertexPoints.get(i);
			List<TilePoint> nearbyPoints = new ArrayList<>();
			
			for (int j = 0; j < tileVertexPoints.size(); j++) {
				
				TilePoint otherPoint = tileVertexPoints.get(j);
				
				if (point.getPoint().isPointNearby(otherPoint.getPoint())) {
					nearbyPoints.add(otherPoint);
				}
			}
			
			if (nearbyPoints.isEmpty()) {
				throw new RuntimeException("no nearby points found");
			}
		
			double sumX = 0;
			double sumY = 0;
			
			for (TilePoint nearbyPoint : nearbyPoints) {
				sumX += nearbyPoint.getPoint().getX();
				sumY += nearbyPoint.getPoint().getY();
			}
			
			double averageX = sumX / (double) (nearbyPoints.size());
			double averageY = sumY / (double) (nearbyPoints.size());
			
			Point intersectionPoint = new Point(averageX, averageY);
			
			Intersection inters = new Intersection(intersectionPoint);
			
			for (TilePoint nearbyPoint : nearbyPoints) {
				Tile tile = nearbyPoint.getTile();
				tile.getPlaces().add(inters);
				inters.addTile(tile);
			}
						
			Circle circle = new Circle();
			circle.setRadius(TileGraphics.PLACE_CIRCLE_RADIUS);
			circle.setCenterX(intersectionPoint.getX());
			circle.setCenterY(intersectionPoint.getY());
			circle.setFill(Color.RED);
//			circle.setVisible(false);
			circle.setStroke(Color.BLACK);
			circle.setOnMouseClicked((event) -> System.out.println(inters));

			inters.setShape(circle);

			intersections.add(inters);
		}
				
		places.addAll(intersections);
		places.addAll(paths);
	}

	/**
	 * shuffles the board tiles: randomizes the order, but 7 is always desert, just different position
	 */
	public void shuffle() {

		for (int i = 0; i < 18; i++) {
			int randomPosition = Logic.randomNumber(0, 18);
			Tile temp = boardTiles[i];
			boardTiles[i] = boardTiles[randomPosition];
			boardTiles[randomPosition] = temp;
		}
		
		Tile desert = getDesert();
		Tile tileAt7  = getTilesWithValue(7).get(0); // only 1
		
		int desertPos = getTileArrayPos(desert);
		int tileAt7Pos = getTileArrayPos(tileAt7);
		
		Tile temp = tileAt7;
		boardTiles[tileAt7Pos] = desert;
		boardTiles[desertPos] = temp;
	}
	
	/**
	 * Generate the board's tile set: initialize tiles, randomize order, set values
	 */
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
		
		for (int v = 0; v < VALUES.length; v++) {
			boardTiles[v].setRollValue(VALUES[v]); // tile value is set by VALUES
		}

		shuffle(); // shuffle tiles to randomize board

	}
	
	/**
	 * Puts all tile shapes in a list
	 * @return List<Node>
	 */
	public List<Node> buildTileShapes() {
		makeTileGraphics();

		List<Node> nodes = new ArrayList<>();

		for (Tile tile : this.boardTiles) {
			TileGraphics gfx = tile.getTileGraphics();

			nodes.addAll(gfx.makeShapes());
		}

		return nodes;
	}

	/**
	 * Puts all place shapes in a list
	 * @return List<Node>
	 */
	public List<Node> buildPlaceShapes() {
		makePlaceGraphics();
		
		List<Node> nodes = new ArrayList<>();

		for (Place p : places) {
			nodes.add(p.getShape());
		}
		
		return nodes;
	}
	
}