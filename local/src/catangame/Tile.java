package catangame;

import java.util.*;



/**
 * Tile(int id, TileType type, int value, List<Building> buildings)
 *
 */
public class Tile {
	int id;
	int value;
	//private List<Building> buildings;
	private TileType type; // each Tile.Type affects related Item.Type
	//private int[] pos; // (x,y) does the tile actually need to know where it is? or can board handle that?
	
	Tile(int id, TileType type, int value) { // , List<Building> buildings
		this.id = id; // does tile need to know its id?
		this.type = type;
		this.value = value;
		//this.buildings = buildings;
	}
	
	Tile() {}
	
	@Override
	public String toString() {
		return "ID: " + id + ", Value: " + value + ", TileType: " + type +  ", Resource: " + type.getResource();// + ", Buildings: " + buildings.toString(); //+ " , Position: (" + x + ", " + y + ")" ;
	}
	
	
	
}