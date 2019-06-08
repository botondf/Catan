package catan;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;

import javafx.scene.text.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
//import javafx.scene.shape.Shape;
import javafx.scene.shape.Shape;

public class Hexagon {
	private static final double HEX_STROKE_WIDTH_DEFAULT = 5;
	private static final double HEX_STROKE_WIDTH_SELECTED= 7;
	private static final Color HEX_STROKE_COLOR_SELECTED = Color.BLUE;
	private static final Color HEX_STROKE_COLOR_DEFAULT = Color.BLACK;
	private static final double FONT_SIZE = 15;
	private double x;
	private double y;
	private Polygon hex;
	private Circle circle;
	private Text text;
	private Tile tile;

	Hexagon(Tile tile) {
		this.tile = tile;
	}

	@Override
	public String toString() {
		return "Hexagon [x=" + x + ", y=" + y + ", hex=" + hex + "]";
	}

	private Circle makeCircle() {
		Circle circle = new Circle();
		circle.setRadius(FONT_SIZE * 1.1);
		circle.setCenterX(x);
		circle.setCenterY(y);
		circle.setFill(Color.ALICEBLUE);
		circle.setStroke(Color.BLACK);
		return circle;
	}

	private Text makeText() {
		Text text = new Text();
		text.setX(x - FONT_SIZE / 3);
		text.setY(y + FONT_SIZE / 3);
		text.setTextAlignment(TextAlignment.CENTER);
		text.setText(Integer.toString(tile.getRollValue()));
		text.setFill(Color.BLACK);
		text.setFont(Font.font("Arial", FontWeight.NORMAL, FONT_SIZE));
		return text;
	}

	private Polygon makeRegularHexagon() {
		double[] points = { x + 50, y + 86.6, x + 100, y, x + 50, y - 86.6, x - 50, y - 86.6, x - 100, y, x - 50,
				y + 86.6 };

		Polygon hexagon = new Polygon(points);
		hexagon.setFill(tile.getColor());
		hexagon.setStroke(tile.isSelected() ? HEX_STROKE_COLOR_SELECTED : HEX_STROKE_COLOR_DEFAULT);
		hexagon.setStrokeWidth(HEX_STROKE_WIDTH_DEFAULT);
		hexagon.setOnMouseClicked((event) -> tile.toggleSelected());
		return hexagon;
	}

	public void rotatePoints(int n, double radius) {
		this.x = (int) (radius * Math.cos(Math.toRadians(n * 60)));
		this.y = (int) (radius * Math.sin(Math.toRadians(n * 60)));
	}

	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
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
}