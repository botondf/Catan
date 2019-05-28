package catangame;

public class Tile {
	int id;
	int value;
	Building[] buildings;
	TileType type; // each Tile.Type affects related Item.Type
	int[] pos; // (x,y)
	
	enum TileType {
		HILLS, PASTURE, FOREST, MOUNTAIN, FIELDS, DESERT
	}
	
	Tile(int id, TileType type, int value, Building[] buildings) {
		
	}
}