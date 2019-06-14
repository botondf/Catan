package catan;

import java.util.*;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

/**
 * Stores the <code> int </code> value of the building type (which is the
 * resource gain multiplier, and the worth in VP's), the cost of each building
 * type, and a <code> String </code> label Builds the random board.
 */

enum BuildingType {
	ROAD("Road", 0, Arrays.asList(new Item(ItemType.BRICK), new Item(ItemType.LUMBER))),
	VILLAGE("Village", 1, Arrays.asList(new Item(ItemType.GRAIN), new Item(ItemType.LUMBER))),
	CITY("City", 2, Arrays.asList(new Item(ItemType.GRAIN), new Item(ItemType.ORE)));

//	static Rectangle road = new Rectangle();
//	static Image village = new Image(getClass().getResourceAsStream("icon.png"));
//	static Image city = new Image(getClass().getResourceAsStream("icon.png"));

	private int value;
	private String label;
	private List<Item> cost;
//	private List<Node> gfx;

	BuildingType(String label, int value, List<Item> cost) { //Node gfx
		this.label = label;
		this.value = value;
		this.cost = cost;
//		this.gfx = gfx;
	}

	public int getValue() {
		return value;
	}

	public List<Item> getCost() {
		return this.cost;
	}

	public String getLabel() {
		return label;
	}

}