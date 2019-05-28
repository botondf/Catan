package catangame;

import java.lang.Math;

public class Building {
	BuildingType type;
	int value;
	Player owner;
	int[] tilePos; // list of min 2 Tile.id 's

	enum BuildingType {
		ROAD("Road", 0), VILLAGE("Village", 1), TOWN("Town", 2);

		private final int value;
		public final String label;

		BuildingType(final String newLabel, final int newValue) {
			label = newLabel;
			this.value = newValue;
		}

//		public int getValue() {
//			return value;
//		}
	}
	
	
	Building(BuildingType type, int value, Player owner, int[] pos) {
		this.type = type;
		this.value = value;
		this.owner = owner;
		this.tilePos = new int[2];
	}
	
	Building() {
		
	}
	
	public static Building debugCreateRandom() {
		BuildingType type = BuildingType.values()[Board.randomNumber(0, 2)];
		int value = Board.randomNumber(1, 12);
		if (type == BuildingType.ROAD) {
			value = 0;
		}
		Player owner = new Player(1);
		int[] pos = new int[] {1, 3, 5};
		
		return new Building(type, value, owner, pos);
	}
	
	public void print() {
		int x = tilePos[0];
		int y = tilePos[1];
		System.out.println("BuildingType: " + type + ", Value: " + value + ", Owner: " + owner.id + " , Position: (" + x + ", " + y + ")");
	}
}
