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
	List<ItemType> cost;
	
	// enum building colour
	
	@Override
	public String toString() {
		return "BuildingType: " + type + " , Value: " + getValue() + ", Owner: " + owner.id + ", Position: (" + position +")";
	}
	
	
	Building(BuildingType type, Player owner, Tile[] position, List<ItemType> cost) {//Place position) {
		this.type = type;
		this.owner = owner;
		this.position = position;
		this.cost = cost;
	}
	
	public int getValue() {
		return type.getValue();
	}
	
	public boolean isBuildable() {
		return (this.cost.isEmpty()) ? true : false;
		return (this.cost.contains(type.getCost())) ? true : false;
		
		return true;
		
	}
	
}
