package catan;

import javafx.scene.text.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
	private static final double PLACE_CIRCLE_RADIUS = 10;
	private CentrePoint centre;
	private Polygon hex;
	private Circle circle;
	private Text text;
	private Tile tile;
	private List<Place> places;
	public static final double K = 100;

	TileGraphics(Tile tile) {
		this.tile = tile;
	}

	@Override
	public String toString() {
		return "Hexagon [centre=" + centre + ", hex=" + hex + "]";
	}

	public CentrePoint getCentre() {
		return centre;
	}

	private Circle makeCircle() {
		Circle circle = new Circle();
		circle.setRadius(FONT_SIZE * 1.1);
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
	

	
	private void makePlaces() {
		
		List<Place> shapes = new ArrayList<>();
		
		double[] vertices = makeVertices();
		double[] edges = makeEdges();
		
		transformPoints(K, centre.getPoint(), vertices);
		transformPoints(K, centre.getPoint(), edges);
		
		for (int i = 0; i < vertices.length; i+=2) {
			Circle circle = new Circle();
			circle.setRadius(PLACE_CIRCLE_RADIUS);
			circle.setCenterX(vertices[i]);
			circle.setCenterY(vertices[i+1]);
			circle.setFill(Color.ALICEBLUE);
			circle.setStroke(Color.BLACK);
			circle.setVisible(false);

			Place place = new Place(PlaceType.INTERSECTION);
			place.setShape(circle);
			places.add(place);
		}
		
		for (int i = 0; i < edges.length; i+=2) {
			Circle circle = new Circle();
			circle.setRadius(PLACE_CIRCLE_RADIUS);
			circle.setCenterX(edges[i]);
			circle.setCenterY(edges[i+1]);
			circle.setFill(Color.RED);
			circle.setStroke(Color.BLACK);
			circle.setVisible(false);
			
			Place place = new Place(PlaceType.INTERSECTION);
			place.setShape(circle);
			places.add(place);
		}
	}

	private Polygon makeRegularHexagon() {
		double[] vertices = makeVertices();
		transformPoints(K, centre.getPoint(), vertices);
		
		Polygon hexagon = new Polygon(vertices);
		hexagon.setFill(tile.getColor());
		hexagon.setStroke(tile.isSelected() ? HEX_STROKE_COLOR_SELECTED : HEX_STROKE_COLOR_DEFAULT);
		hexagon.setStrokeWidth(HEX_STROKE_WIDTH_DEFAULT);
		hexagon.setOnMouseClicked((event) -> tile.toggleSelected());
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

	public List<Shape> makeShapes() {
		hex = makeRegularHexagon();
		circle = makeCircle();
		text = makeText();
		return getShapes();
	}

	public void redraw() {
		hex.setStroke(tile.isSelected() ? HEX_STROKE_COLOR_SELECTED : HEX_STROKE_COLOR_DEFAULT);
		hex.setStrokeWidth(tile.isSelected() ? HEX_STROKE_WIDTH_SELECTED : HEX_STROKE_WIDTH_DEFAULT);
		
//		if (tile.isSelected()) {
//			getPlaces().forEach(getShapes().forEach(setVisibility(true)));
//		}
	}

	public List<Shape> getShapes() {
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