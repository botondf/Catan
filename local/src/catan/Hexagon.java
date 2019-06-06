package catan;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Hexagon {
	double x;
	double y;
	Polygon hex;
	Color color;
	
	Hexagon(double x, double y) {
		this.x = x;
		this.y = y;
		this.hex = makeRegularHexagon(this.x, this.y);
		//this.color = color;
	}
	
	@Override
	public String toString() {
		return "Hexagon [x=" + x + ", y=" + y + ", hex=" + hex + "]";
	}

	public void rotatePoints(int n, double radius) {
        this.x = (int) (radius * Math.cos(Math.toRadians(n*60)));
        this.y = (int) (radius * Math.sin(Math.toRadians(n*60)));
	}
	
	public void setCentre(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void setColor(Color color) {
		this.color = color;
		this.hex.setFill(color);
	}
	
	 public Polygon makeRegularHexagon(double x, double y) {
	    	double[] points = {
//	    			x+50, y+0,
//	    			x+150, y+0,
//	    			x+200, y+86.6,
//	    			x+150, y+173.2,
//	    			x+50, y+173.2,
//	    			x+0, y+86.6
	    			x+50, y+86.6,//
	    			x+100, y,//
	    			x+50, y-86.6,//
	    			x-50, y-86.6,
	    			x-100, y,
	    			x-50, y+86.6
				};
	    	
	    	Polygon hexagon = new Polygon(points);
	    	hexagon.setFill(color);
			return hexagon;
	    }
	 
	 public static void main(String[] args) {
		 Hexagon hex = new Hexagon(100, 100);
		 System.out.println(hex.toString());
		 hex.rotatePoints(1, 60);
		 System.out.println(hex.toString());
	 }
}