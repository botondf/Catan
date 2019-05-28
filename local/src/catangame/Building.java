package catangame;

import java.lang.Math;

public class Building {
	BuildingType type;
	//int value;
	private Player owner;
	private Position position;
	
	// enum building colour
	
	@Override
	public String toString() {
		return "BuildingType: " + type + " , Position: (" + position +")";
	}
	
	
	Building(BuildingType type, Position position) {
		this.type = type;
		this.position = position;
	}
	
	public int getValue() {
		return type.getValue();
	}
	
	public static Building debugCreateRandom() {
		BuildingType type = BuildingType.values()[Board.randomNumber(0, 2)];
		int value = Board.randomNumber(1, 12);
		if (type == BuildingType.ROAD) {
			value = 0;
		}
		Player owner = new Player(1);
		int[] pos = new int[] {1, 3, 5};
		
		return new Building(type, owner, pos);
	}
	
	
}
