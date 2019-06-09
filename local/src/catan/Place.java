package catan;

import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.shape.Shape;

public class Place {

	private PlaceType placeType;
//	private Button placeBuildingButton;
	private double x;
	private double y;
	private Shape shape;
	private List<Tile> connectedTiles;

	Place(PlaceType placeType) { //Place neighbours
		//this.neighbours = neighbours;
		this.placeType = placeType;
	}
	
	
	@Override
	public String toString() {
		return "Place [placeType=" + placeType + "]";
	}
	
	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public void findNeighbours() {

	}

}
