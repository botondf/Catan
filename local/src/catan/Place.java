package catan;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.shape.Shape;

public class Place {

	private PlaceType placeType;
	private Button placeBuildingButton;
	private double x;
	private double y;
	private Node shape;
	private List<Tile> connectedTiles;
	private List<Tile> tiles = new ArrayList<>();

	Place(PlaceType placeType) { //Place neighbours
		//this.neighbours = neighbours;
		this.placeType = placeType;
	}
	
	Place () {
	}
	
	
	@Override
	public String toString() {
		return "Place [placeType=" + placeType + "]";
	}
	
	public Node getShape() {
		return shape;
	}

	public void setShape(Node shape) {
		this.shape = shape;
	}

	public void findNeighbours() {

	}

	public void addTile(Tile tile) {
		tiles.add(tile);		
	}

	public List<Tile> getTiles() {
		return tiles;
	}
}
