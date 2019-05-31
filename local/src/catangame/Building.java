package catangame;

import java.lang.Math;
import java.util.*;
import catangame.TileType.*;

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
	List<Item> cost;
	
	// enum building colour
	
	@Override
	public String toString() {
		return "BuildingType: " + type + " , Value: " + getValue() + ", Owner: " + owner.id + ", Position: (" + position +")";
	}
	
	
	Building(BuildingType type, Player owner, Tile[] position, List<Item> cost) {//Place position) {
		this.type = type;
		this.owner = owner;
		this.position = position;
		this.cost = cost;
	}
	
	Building(BuildingType type) {
		this.type = type;
	}
	
	public int getValue() {
		return type.getValue();
	}
	
}
