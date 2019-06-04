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
	//int id;
	int value;
	List<Building> buildings;
	TileType type; // each Tile.Type affects related Item.Type
	Button button;
	// Graphics
	Polygon tileShape;
	//private int[] pos; // (x,y) does the tile actually need to know where it is? or can board handle that?
	
	Tile(TileType type, int value, List<Building> buildings) { // 
		//this.id = id; // does tile need to know its id?
		this.setType(type);
		this.value = value;
		this.setBuildings(buildings);
	}
	
//	@Override
//	public String toString() {
//		return "Value: " + value + ", TileType: " + getType() +  ", Resource: " + getType().getResource() + ", Buildings: " + getBuildings().toString(); //+ " , Position: (" + x + ", " + y + ")" ;
//	}
	
	@Override
	public String toString() {
		return "Tile [value=" + value + ", buildings=" + buildings + ", type=" + type + ", button=" + button + "]";
	}

	public void setValue(int value) {
		this.value = value;
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