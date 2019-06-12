package catan;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;

public class Place {

	private PlaceType placeType;

	private Node shape;
	private List<Tile> tiles = new ArrayList<>();
	private Building building;

	Place(PlaceType placeType) {
		this.placeType = placeType;
	}
	
	Place () {
	}
	
	
	@Override
	public String toString() {
		return "Place [placeType=" + placeType + "]";
	}
	
	public void addBuilding(Building building) {
		this.building = building;
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
