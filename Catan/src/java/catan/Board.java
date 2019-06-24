package catan;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

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
	public Tile[] boardTiles = new Tile[19]; // total 19 tiles
	public List<Tile> rollSelectedTiles;
	public List<Intersection> intersections = new ArrayList<>();
	public List<Path> paths = new ArrayList<>();
	public List<Place> places = new ArrayList<>();
	public CentrePoint[] centrePoints = new CentrePoint[19];
	
	public Board() {
		tessellation(Catan.scale.getTileEdge());
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
	private void tessellation(double edge) {
		double x = Catan.SCREEN_WIDTH / 2;
		double y = Catan.SCREEN_HEIGHT / 2;
		//double edge = 105; // length of one edge of hex
		double length = (Math.sqrt(3) * edge) + 1;
		double a = length * Math.cos(Math.toRadians(60));
		double b = length * Math.cos(Math.toRadians(30));
		double c1 = 3 * edge * Math.tan(Math.toRadians(30));
		double c2 =  1.5 * edge * Math.tan(Math.toRadians(60));

		// setting centre (position) of each tile pos counter-clockwise from middle tile based on base x, y		
		centrePoints[0] = new CentrePoint(x, y);
		centrePoints[1] = new CentrePoint(x - b, y - a);
		centrePoints[2] = new CentrePoint(x, y - length);
		centrePoints[3] = new CentrePoint(x + b, y - a);
		centrePoints[4] = new CentrePoint(x + b, y + a);
		centrePoints[5] = new CentrePoint(x, y + length);
		centrePoints[6] = new CentrePoint(x - b, y + a);
		centrePoints[7] = new CentrePoint(x - 3 * edge, y);
		centrePoints[8] = new CentrePoint(x - 3 * edge, y - c1);
		centrePoints[9] = new CentrePoint(x - 1.5 * edge, y - c2);
		centrePoints[10] = new CentrePoint(x, y - 2 * length);
		centrePoints[11] = new CentrePoint(x + 1.5 * edge, y - c2);
		centrePoints[12] = new CentrePoint(x + 3 * edge, y - c1);
		centrePoints[13] = new CentrePoint(x + 3 * edge, y);
		centrePoints[14] = new CentrePoint(x + 3 * edge, y + c1);
		centrePoints[15] = new CentrePoint(x + 1.5 * edge, y + c2);
		centrePoints[16] = new CentrePoint(x, y + 2 * length);
		centrePoints[17] = new CentrePoint(x - 1.5 * edge, y + c2);
		centrePoints[18] = new CentrePoint(x - 3 * edge, y + c1);
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
	
	/**
	 * Initializes all of the place graphics - paths then intersections
	 */
	private void makePlaceGraphics() {
		this.reset();
		makeIntersections();
		makePaths();
						
		places.addAll(paths);
		places.addAll(intersections);

	}

	/**
	 * Initializes the intersections of the board
	 */
	private void makeIntersections() {
		List<TileVertex> tileVertexPoints = new ArrayList<>();
			
		for (Tile tile : boardTiles) {
			
			CentrePoint centrePoint = tile.getTileGraphics().getCentre();
			
			for (int j = 0; j < 6; j++) {
				Point point = centrePoint.getVerticePointAt(j);
				tileVertexPoints.add(new TileVertex(point, tile));
			}
		}

		Set<Point> intersectionPoints = new HashSet<>();
		
		// INTERSECTIONS
		for (int i = 0; i < tileVertexPoints.size(); i++) {
			
			TileVertex vertex = tileVertexPoints.get(i);
			List<TileVertex> nearbyVertices = new ArrayList<>();
			
			for (int j = 0; j < tileVertexPoints.size(); j++) {
				
				TileVertex otherPoint = tileVertexPoints.get(j);
				
				if (vertex.getPoint().isPointNearby(otherPoint.getPoint())) {
					nearbyVertices.add(otherPoint);
				}
			}
			
			if (nearbyVertices.isEmpty()) {
				throw new RuntimeException("no nearby points found");
			}
		
			double sumX = 0;
			double sumY = 0;
			
			for (TileVertex nearbyVertex : nearbyVertices) {
				sumX += nearbyVertex.getPoint().getX();
				sumY += nearbyVertex.getPoint().getY();
			}
			
			double averageX = sumX / (double) (nearbyVertices.size());
			double averageY = sumY / (double) (nearbyVertices.size());
			
			Point intersectionPoint = new Point(averageX, averageY);
			
			if (!intersectionPoints.contains(intersectionPoint)) {
				intersectionPoints.add(intersectionPoint);
				final Intersection inters = new Intersection(intersectionPoint);

				for (TileVertex nearbyPoint : nearbyVertices) {
					Tile tile = nearbyPoint.getTile();
					tile.getPlaces().add(inters);
					inters.addTile(tile);
				}

				inters.setShape(inters.makeEmptyShape());

				intersections.add(inters);
			}
		}
		
		// Print how many intersections it made for debugging
		//System.out.println("intersections " + intersections.size());
	}

	/**
	 * Initializes the paths of the board
	 */
	private void makePaths() {
		List<TileSide> tileSidePoints = new ArrayList<>();
			
		for (Tile tile : boardTiles) {
			
			CentrePoint centrePoint = tile.getTileGraphics().getCentre();

			for (int j = 0; j < 6; j++) {
				Side side = centrePoint.getSideAt(j);
				
				tileSidePoints.add(new TileSide(side, tile));
			}
		}
		
		// Using a set to hold points as there should only be one path at recurring points
		Set<Point> pathPoints = new HashSet<>();

		// PATHS
		for (int i = 0; i < tileSidePoints.size(); i++) {
			
			TileSide tileSide = tileSidePoints.get(i);
			List<TileSide> nearbyPoints = new ArrayList<>();
			
			for (int j = 0; j < tileSidePoints.size(); j++) {
				TileSide otherTileSide = tileSidePoints.get(j);

				if(tileSide.isNearby(otherTileSide)) {
					nearbyPoints.add(otherTileSide);
				}
			}
			
			// There should be a few nearby points found
			if (nearbyPoints.isEmpty()) {
				throw new RuntimeException("no nearby points found");
			}
		
			// Calculate the average of all nearby points found to get a new point
			double sumX = 0;
			double sumY = 0;
			
			for (TileSide nearbyPoint : nearbyPoints) {
				sumX += nearbyPoint.getSide().getCentre().getX();
				sumY += nearbyPoint.getSide().getCentre().getY();
			}
			
			double averageX = sumX / (double) (nearbyPoints.size());
			double averageY = sumY / (double) (nearbyPoints.size());
			
			// Set average point as the point of the path
			Point pathPoint = new Point(averageX, averageY);
			
			// Ensure there are no recurrences before creating the Path
			if (!pathPoints.contains(pathPoint)) {
				pathPoints.add(pathPoint);

				// Find the intersections connected to the path, and use them to make a new Path
				List<Intersection> pathIntersections = findIntersectionsNearby(pathPoint);
				Intersection intersA = pathIntersections.get(0);
				Intersection intersB = pathIntersections.get(1);
				Path path = new Path(pathPoint, intersA, intersB);

				// Add the path to the tile's list of places
				for (TileSide nearbyPoint : nearbyPoints) {
					Tile tile = nearbyPoint.getTile();
					tile.getPlaces().add(path);
					path.addTile(tile);
				}
				
				// Generate the empty graphics for each Path (circle)
				path.setShape(path.makeEmptyShape());
				
				// Add this Node to the collection of path Nodes
				paths.add(path);
			}
			
		}
	}
	
	private List<Intersection> findIntersectionsNearby(Point point) {
		List<Intersection> list = new ArrayList<>(2);
		for(Intersection intersection : intersections) {
			if(intersection.getPoint().isPointNearby(point, TileGraphics.PATH_CENTER_RADIUS)) {
				list.add(intersection);
			}
		}
		
		if(list.size() != 2) {
			throw new IllegalArgumentException("No two intersections for path at center point " + point +
					", size=" + list.size() + ", intersections=" + list);
		}
		return list;
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
		Tile tileWith7  = boardTiles[10]; // Tile at 10 is the desert tile (pre-generation) - only 1
		
		int desertPos = getTileArrayPos(desert);
		int tileAt7Pos = 10;
		
		boardTiles[tileAt7Pos] = desert;
		boardTiles[desertPos] = tileWith7;
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
		
		shuffle(); // shuffle tiles to randomize board
		
		for (int v = 0; v < VALUES.length; v++) {
			boardTiles[v].setRollValue(VALUES[v]); // tile value is set by VALUES
		}

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
	
	public void reset() {
		intersections.clear();
	}
}