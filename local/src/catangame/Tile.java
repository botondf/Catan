package catangame;

import java.util.*;



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
	//private List<Building> buildings;
	private TileType type; // each Tile.Type affects related Item.Type
	//private int[] pos; // (x,y) does the tile actually need to know where it is? or can board handle that?
	
	Tile(TileType type, int value) { // , List<Building> buildings
		//this.id = id; // does tile need to know its id?
		this.setType(type);
		this.value = value;
		//this.buildings = buildings;
	}
	
	Tile() {}
	
	@Override
	public String toString() {
		return "Value: " + value + ", TileType: " + getType() +  ", Resource: " + getType().getResource();// + ", Buildings: " + buildings.toString(); //+ " , Position: (" + x + ", " + y + ")" ;
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
	
	
}