package catangame;

public class Tile {
	int id;
	int value;
	Building[] buildings;
	Type type; // each Tile.Type affects related Item.Type
	int[] pos; // (x,y)
	
	enum Type {
		HILLS, PASTURE, FOREST, MOUNTAIN, FIELDS, DESERT
	}
	
}