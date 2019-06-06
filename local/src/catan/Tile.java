package catan;

import java.util.*;
import javafx.scene.control.Button;
import javafx.scene.shape.Polygon;


/**
 * Tile(TileType type, int value, List<Building> buildings)
 * has own type (w/ item/resource) and value
 * holds the buildings that are connected to it
 * doesn't know its location
 *
 */
public class Tile {
	int value;
	List<Building> buildings;
	TileType type; // each Tile.Type affects related Item.Type
	double x;
	double y;
	Hexagon shape;
	
	//Button button;
	// Graphics
	//Polygon tileShape;
	//private int[] pos; // (x,y) does the tile actually need to know where it is? or can board handle that?
	
	Tile(TileType type, int value, List<Building> buildings) { // 
		//this.id = id; // does tile need to know its id?
		this.setType(type);
		this.value = value;
		this.setBuildings(buildings);
	}
	
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Tile [value=" + value + ", buildings=" + buildings + ", type=" + type + ", centre=("+x+","+y+")]";
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setShape(Hexagon shape) {
		this.shape = shape;
	}
	
	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type = type;
	}

	public List<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}
	
	
}