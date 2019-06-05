package catan;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Hexagon {
	int x;
	int y;
	Color color;
	Polygon shape;
	
	Hexagon(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	 public static Polygon makeRegularHexagon(int x, int y, Color color) {
	    	double[] points = {
	    			x+5, y+0,
	    			x+15, y+0,
	    			x+20, y+8.66,
	    			x+15, y+17.32,
	    			x+5, y+17.32,
	    			x+0, y+8.66
	    			
//	    			x+50, y+0,
//	    			x+150, y+0,
//	    			x+200, y+86.6,
//	    			x+150, y+173.2,
//	    			x+50, y+173.2,
//	    			x+0, y+86.6
				};
	    	
	    	Polygon hexagon = new Polygon(points);
	    	hexagon.setFill(color);
			return hexagon;
	    }
}