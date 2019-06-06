package catan;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Hexagon {
	double FONT_SIZE = 15;
	double x;
	double y;
	Polygon hex;
	Color color;
	Circle circle;
	Text text;
	int tileValue;
	
	Hexagon(double x, double y, int tileValue) {
		this.x = x;
		this.y = y;
		this.tileValue = tileValue;
		makeRegularHexagon(x, y);
		makeCircle();
		makeText();
		//this.color = color;
	}

	public void makeCircle() {
		this.circle = new Circle();
		circle.setRadius(FONT_SIZE*1.1);
		circle.setCenterX(x);
		circle.setCenterY(y);
		circle.setFill(Color.ALICEBLUE);
		circle.setStroke(Color.BLACK);

	}
	
	public void makeText() {
		this.text = new Text();
		text.setX(x-FONT_SIZE/3);
		text.setY(y+FONT_SIZE/3);
		text.setTextAlignment(TextAlignment.CENTER);
		text.setText(Integer.toString(this.tileValue));
		text.setFill(Color.BLACK);
		text.setFont(Font.font("Arial", FontWeight.NORMAL, FONT_SIZE));
	}
	
	@Override
	public String toString() {
		return "Hexagon [x=" + x + ", y=" + y + ", hex=" + hex + "]";
	}

	public void rotatePoints(int n, double radius) {
        this.x = (int) (radius * Math.cos(Math.toRadians(n*60)));
        this.y = (int) (radius * Math.sin(Math.toRadians(n*60)));
	}
	
	public List<Shape> makeTile(int x, int y) {
		List<Shape> shapes = new ArrayList<Shape>();
		double r = 20.0;
    	Circle circle = new Circle();
    	circle.setCenterX(x+100);
    	circle.setCenterY(y+100-r/2);
    	circle.setRadius(r);
    	circle.setFill(Color.BLANCHEDALMOND);
    	circle.setStroke(Color.BLACK);
    	
    	shapes.add(hex);
    	shapes.add(circle);
		return shapes;	
    }
	
	public void setCentre(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void setColor(Color color) {
		this.color = color;
		this.hex.setFill(color);
	}
	
	 public void makeRegularHexagon(double x, double y) {
	    	double[] points = {
	    			x+50, y+86.6,
	    			x+100, y,
	    			x+50, y-86.6,
	    			x-50, y-86.6,
	    			x-100, y,
	    			x-50, y+86.6
				};
	    	
	    	Polygon hexagon = new Polygon(points);
	    	hexagon.setFill(color);
	    	hexagon.setStroke(Color.BLACK);
	    	//hexagon.setOnMouseClicked(value);
			this.hex = hexagon;
	    }
}