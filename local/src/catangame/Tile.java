package catangame;

import java.util.*;



/**
 * Tile(int id, TileType type, int value, Building[] buildings)
 *
 */
public class Tile {
	//private int id;
	private int value;
	private List<Building> buildings;
	private TileType type; // each Tile.Type affects related Item.Type
	private int[] pos; // (x,y)
	
	Tile(int id, TileType type, int value, List<Building> buildings) {
		
	}
	
	Tile() {
		
	}
	
	@Override
	public String toString() {
		int x = pos[0];
		int y = pos[1];
		return "TileType: " + type + ", Value: " + value + ", Buildings: " + buildings.toString() + " , Position: (" + x + ", " + y + ")" ;
	}
	
	public static Tile debugCreateRandom() {
		int id = Board.randomNumber(1,10);
		TileType type = TileType.values()[Board.randomNumber(0, 5)];
		int value = Board.randomNumber(1, 12);
		List<Building> buildings = new ArrayList<Building>();
		return new Tile(id, type, value, buildings);
	}
	
}