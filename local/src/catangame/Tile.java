package catangame;

import catangame.Item.ItemType;

public class Tile {
	int id;
	int value;
	Building[] buildings;
	TileType type; // each Tile.Type affects related Item.Type
	int[] pos; // (x,y)
	
	enum TileType {
		HILLS("Hills", ItemType.BRICK), PASTURE("Pasture", ItemType.CATTLE), 
		FOREST("Forest", ItemType.LUMBER), MOUNTAIN("Mountain", ItemType.ORE),
		FIELDS("Fields", ItemType.GRAIN), DESERT
		
		private final ItemType resource;
		public final String label;
		
		TileType(String newLabel, final ItemType newResource) {
			label = newLabel;
			this.ItemType = newResource;
		}

	}
	
	Tile(int id, TileType type, int value, Building[] buildings) {
		
	}
}