package catangame;

import java.lang.Math;

public class Building {
	BuildingType type;
	int value;
	Player owner;
	int[] pos; // list of min 2 Tile.id 's

	enum BuildingType {
		ROAD("Road", 0), VILLAGE("Village", 1), TOWN("Town", 2);

		private final int value;
		public final String label;

		BuildingType(String newLabel, final int newValue) {
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
		this.pos = new int[2];
	}
	
	Building() {
		
	}
	
	public void debugCreateRandom() {
		type = BuildingType.values()[randomNumber(0, 2)];
		if (type == BuildingType.ROAD) {
			value = 0;
		} else {
			value = randomNumber(1, 12);
		}
		
		owner = new Player(1);
		pos = new int[] {1, 3, 5};
	}
	
	public void print() {
		System.out.println("Type: " + type + ", Value: " + value + ", Owner: " + owner + " , Position: " + pos);
	}
	
	public int randomNumber(int a, int b) {
	    int highNum = Math.max(a, b);
	    int lowNum = Math.min(a, b);
	    int range = highNum - lowNum + 1;
	    return (int) (Math.random() * range) + lowNum;
	}
}
