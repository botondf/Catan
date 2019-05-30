package catangame;

import java.util.*;



/**
 * Tile(int id, TileType type, int value, List<Building> buildings)
 *
 */
public class Tile {
	private int id;
	private int value;
	private List<Building> buildings;
	private TileType type; // each Tile.Type affects related Item.Type
	//private int[] pos; // (x,y) does the tile actually need to know where it is? or can board handle that?
	
	Tile(int id, TileType type, int value, List<Building> buildings) {
		this.id = id;
		this.type = type;
		this.value = value;
		this.buildings = buildings;
	}
	
	@Override
	public String toString() {
		return "TileType: " + type + ", Value: " + value + ", Buildings: " + buildings.toString(); //+ " , Position: (" + x + ", " + y + ")" ;
	}
	
	
	
}