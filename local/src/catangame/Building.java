package catangame;

public class Building {
	Type type;
	int value;
	int[] pos; // list of min 2 Tile.id 's
	
	enum Type {
		ROAD, VILLAGE, TOWN
	}
}
