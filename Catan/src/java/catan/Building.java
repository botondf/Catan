package catan;

import java.util.*;

/**
 * 
 * Building(BuildingType type, Player owner, Tile[] position)//Place position)
 *
 */
public class Building {
	private BuildingType type;
	private Player owner;
	private Place place;
	private List<Item> cost;
	private BuildingGraphics graphics;

	Building(BuildingType type, Player owner, Place place) {
		this.type = type;
		this.owner = owner;
		this.place = place;
		this.cost = type.getCost();
	}

	@Override
	public String toString() {
		return "Building [type=" + type + ", owner=" + owner.getId() + ", place=" + place + ", cost=" + cost + "]";
	}

	Building(BuildingType type) {
		this.type = type;
	}

	public int getValue() {
		return type.getValue();
	}

	public BuildingType getType() {
		return type;
	}

	public Player getOwner() {
		return owner;
	}

	public Place getPlace() {
		return place;
	}

	public List<Item> getCost() {
		return cost;
	}

	public BuildingGraphics getGraphics() {
		return graphics;
	}

}