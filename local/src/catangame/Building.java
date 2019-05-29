package catangame;

import java.lang.Math;
import java.util.*;

/**
 * 
 * Building(BuildingType type, Player owner, Tile[] position)//Place position)
 *
 */
public class Building {
	BuildingType type;
	//int value;
	private Player owner;
//	private Place position;
	private Tile[] position;
	private List<ItemType> cost;
	
	// enum building colour
	
	@Override
	public String toString() {
		return "BuildingType: " + type + " , Value: " + getValue() + ", Owner: " + owner.id + ", Position: (" + position +")";
	}
	
	
	Building(BuildingType type, Player owner, Tile[] position, List<ItemType> cost) {//Place position) {
		this.type = type;
		this.position = position;
		this.owner = owner;
	}
	
	public int getValue() {
		return type.getValue();
	}
	
	
	
	
}
