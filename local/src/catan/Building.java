package catan;

import java.lang.Math;
import java.util.*;

import catan.TileType.*;

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
	private Place place;
	List<Item> cost;
	
	// enum building colour
	
//	@Override
//	public String toString() {
//		return "\nBuildingType: " + type + " , Value: " + getValue() + ", Owner: " + owner.id + ", Place: (" + place +")";
//	}
	
	
	Building(BuildingType type, Player owner, Place place) {//Place position, List<Item> cost) {
		this.type = type;
		this.owner = owner;
		this.place = place;
		this.cost = type.getCost();
	}
	
	@Override
	public String toString() {
		return "Building [type=" + type + ", owner=" + owner.id + ", place=" + place + ", cost=" + cost + "]";
	}

	Building(BuildingType type) {
		this.type = type;
	}
	
	public int getValue() {
		return type.getValue();
	}
	
}
