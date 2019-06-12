package catan;

import java.lang.Math;
import java.util.*;

import catan.TileType.*;
import javafx.scene.shape.Rectangle;

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
	private Node graphic;

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
	
	public void draw() {
		Rectangle rect = new Rectangle();
		rect
	}

}
