package catan;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.lang.Math;

import catan.Board.*;

public class BoardUI {
	//public List<Shape> shapes = new ArrayList<Shape>();
	
	public static List<Shape> makeTile(int x, int y) {
		List<Shape> shapes = new ArrayList<Shape>();
		double r = 20.0;
    	Circle circle = new Circle();
    	circle.setCenterX(x+100);
    	circle.setCenterY(y+100-r/2);
    	circle.setRadius(r);
    	circle.setFill(Color.BLANCHEDALMOND);
    	
    	Polygon hexagon = makeRegularHexagon(x,y,Color.BLACK);
    	shapes.add(hexagon);
    	shapes.add(circle);
		return shapes;	
    }

    public static Polygon makeRegularHexagon(int x, int y, Color color) {
    	double[] points = {
    			x + 50,   y + 0,
    			x + 150,  y + 0,
    			x + 200,  y + 86.6,
    			x + 150,  y + 173.2,
    			x + 50,   y + 173.2,
    			x + 0,    y + 86.6
			};
    	
    	Polygon hexagon = new Polygon(points);
    	hexagon.setFill(color);
		return hexagon;
    }
}