package catangame;

import catangame.Building.BuildingType;
import catangame.Item.ItemType;
import java.util.*;



/**
 * Tile(int id, TileType type, int value, Building[] buildings)
 *
 */
public class Tile {
	int id;
	int value;
	List<Building> buildings;
	TileType type; // each Tile.Type affects related Item.Type
	int[] pos; // (x,y)
	
	enum TileType {
		HILLS("Hills", ItemType.BRICK), PASTURE("Pasture", ItemType.CATTLE), 
		FOREST("Forest", ItemType.LUMBER), MOUNTAIN("Mountain", ItemType.ORE),
		FIELDS("Fields", ItemType.GRAIN), DESERT("Desert", null);
		
		private ItemType resource;
		public String label;
		private ItemType type;
		
		TileType(String newLabel, ItemType newResource) {
			label = newLabel;
			type = newResource;
		}

	}
	
	Tile(int id, TileType type, int value, List<Building> buildings) {
		
	}
	
	Tile() {
		
	}
	
	public static Tile debugCreateRandom() {
		int id = Board.randomNumber(1,10);
		TileType type = TileType.values()[Board.randomNumber(0, 5)];
		int value = Board.randomNumber(1, 12);
		List<Building> buildings = new ArrayList<Building>();
		return new Tile(id, type, value, buildings);
	}
	
	public void print() {
		int x = pos[0];
		int y = pos[1];
		System.out.println("TileType: " + type + ", Value: " + value + ", Buildings: " + buildings.toString() + " , Position: (" + x + ", " + y + ")" );
	}
	
}