package catan;

import javafx.scene.text.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
/**
 * @params <code> Tile </code> 
 * Creates hexagon, text, circle
 */
public class TileGraphics {
	private static final double HEX_STROKE_WIDTH_DEFAULT = 4;
	private static final double HEX_STROKE_WIDTH_SELECTED = 6.5;
	private static final Color HEX_STROKE_COLOR_SELECTED = Color.BLUE;
	private static final Color HEX_STROKE_COLOR_DEFAULT = Color.BLACK;
	private static final double FONT_SIZE = 15;
	public static final double PLACE_CIRCLE_RADIUS = 11;
	private CentrePoint centre;
	private Polygon hex;
	private Circle circle;
	private Text text;
	private Tile tile;
	private List<Place> places;
	public static final double TRANSFORMATION = 100;//Board.EDGE * 0.9;

	TileGraphics(Tile tile) {
		this.tile = tile;
	}

	@Override
	public String toString() {
		return "TileGraphics [centre=" + centre + ", hex=" + hex + "]";
	}

	public CentrePoint getCentre() {
		return centre;
	}

	private Circle makeCircle() {
		Circle circle = new Circle();
		circle.setRadius(PLACE_CIRCLE_RADIUS);
		circle.setCenterX(centre.getPoint().getX());
		circle.setCenterY(centre.getPoint().getY());
		circle.setFill(Color.ALICEBLUE);
		circle.setStroke(Color.BLACK);
		return circle;
	}

	private Text makeText() {
		int value = tile.getRollValue();
		double xAlign = (value < 9) ? centre.getPoint().getX() - FONT_SIZE / 3.5 : centre.getPoint().getX() - FONT_SIZE/1.75;
		
		Text text = new Text();
		text.setX(xAlign);
		text.setY(centre.getPoint().getY() + FONT_SIZE / 3);
		text.setTextAlignment(TextAlignment.CENTER);
		text.setText(Integer.toString(value));
		text.setFill(Color.BLACK);
		text.setFont(Font.font("Arial", FontWeight.NORMAL, FONT_SIZE));
		return text;
	}
	
	private double[] makeEdges() {
	double[] edges = {
			0, 1, 
			0.866, 0.5,
			0.866, -0.5,
			0, -1,
			-0.866, -0.5,
			-0.866, 0.5
	};
	return edges;
	}
	private double[] makeVertices( ) {
	double[] vertices = {
			0.5, 0.866, 
			1, 0, 
			0.5, -0.866,
			-0.5, -0.866,
			-1, 0,
			-0.5, 0.866
	};
	return vertices;
	}
	
	public static void transformPoints(double k, Point point, double[] points) {
		for (int i = 0; i < points.length; i+=2) {
			points[i] *= k;
			points[i+1] *= k;
			points[i] += point.getX();
			points[i+1] += point.getY();
		}
	}
	
	//not used
	public void makePlaces() {
		
		List<Node> nodes = new ArrayList<>();
		
		double[] vertices = makeVertices();
		double[] edges = makeEdges();
		
		transformPoints(TRANSFORMATION, centre.getPoint(), vertices);
		transformPoints(TRANSFORMATION-10, centre.getPoint(), edges);
		
		for (int i = 0; i < vertices.length; i+=2) {
			Circle circle = new Circle();
			circle.setRadius(PLACE_CIRCLE_RADIUS);
			circle.setCenterX(vertices[i]);
			circle.setCenterY(vertices[i+1]);
			circle.setFill(Color.ALICEBLUE);
			circle.setStroke(Color.BLACK);
			circle.setVisible(true);

			nodes.add(circle);
//			Place place = new Place(PlaceType.INTERSECTION);
//			place.setShape(circle);
//			places.add(place);
		}
		
		for (int i = 0; i < edges.length; i+=2) {
			Circle circle = new Circle();
			circle.setRadius(PLACE_CIRCLE_RADIUS);
			circle.setCenterX(edges[i]);
			circle.setCenterY(edges[i+1]);
			circle.setFill(Color.RED);
			circle.setStroke(Color.BLACK);
			circle.setVisible(true);
			
			nodes.add(circle);
//			Place place = new Place(PlaceType.INTERSECTION);
//			place.setShape(circle);
//			places.add(place);
		}
		//return nodes;
	}

	private Polygon makeRegularHexagon() {
		double[] vertices = makeVertices();
		
		transformPoints(TRANSFORMATION, getCentre().getPoint(), vertices);
		
		Polygon hexagon = new Polygon(vertices);
		hexagon.setFill(getTile().getColor());
		hexagon.setStroke(getTile().isSelected() ? HEX_STROKE_COLOR_SELECTED : HEX_STROKE_COLOR_DEFAULT);
		hexagon.setStrokeWidth(HEX_STROKE_WIDTH_DEFAULT);
		hexagon.setOnMouseClicked((event) -> getTile().toggleSelected());
		return hexagon;
	}

//	public void rotatePoints(int n, double radius) {
//		this.x = (int) (radius * Math.cos(Math.toRadians(n * 60)));
//		this.y = (int) (radius * Math.sin(Math.toRadians(n * 60)));
//	}

	public void setCentre(double x, double y) {
		this.centre = new CentrePoint(x,y);
	}

	public void setCentre(CentrePoint centre) {
		this.centre = centre;
	}

	public List<Node> makeShapes() {
		hex = makeRegularHexagon();
		circle = makeCircle();
		text = makeText();
		return getShapes();
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public void redraw() {
		boolean isSelected = getTile().isSelected();
		hex.setStroke(isSelected ? HEX_STROKE_COLOR_SELECTED : HEX_STROKE_COLOR_DEFAULT);
		hex.setStrokeWidth(isSelected ? HEX_STROKE_WIDTH_SELECTED : HEX_STROKE_WIDTH_DEFAULT);
		for (Place p : Board.places) {
			System.out.println(getTile().getPlaces());
			p.getShape().setVisible((isSelected) ? true : false);
		}
	}

	public List<Node> getShapes() {
		Objects.requireNonNull(hex, "hex");
		Objects.requireNonNull(circle, "circle");
		Objects.requireNonNull(text, "text");
		return Arrays.asList(hex, circle, text);
	}

	public Polygon getHex() {
		return hex;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

}