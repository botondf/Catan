package catangame;

import java.lang.Math;

public class Building {
	BuildingType type;
	int value;
	Player owner;
	int[] pos; // list of min 2 Tile.id 's
	
	enum BuildingType {
		ROAD, VILLAGE, TOWN
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
		type = BuildingType.values()[randomNumber(0, 4)];
		value = randomNumber(1, 12);
		owner = new Player(1);
		pos = new int[] {1, 3, 5};
	}
	
	public void print() {
		System.out.println("Type: " + type + ", Value:" + value + ", Owner: " + owner + " , Position: " + pos);
	}
	
	public static int randomNumber(int a, int b) {
	    int highNum = Math.max(a, b);
	    int lowNum = Math.min(a, b);
	    int range = highNum - lowNum + 1;
	    return (int) (Math.random() * range) + lowNum;
	}
}
