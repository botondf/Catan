package catan;

import java.util.*;

/**
 * Stores the <code> int </code> value of the building type (which is the
 * resource gain multiplier, and the worth in VP's), the cost of each building
 * type, and a <code> String </code> label Builds the random board.
 */

enum BuildingType {
	ROAD("Road", 0, Arrays.asList(new Item(ItemType.BRICK), new Item(ItemType.LUMBER))),
	SETTLEMENT("Settlement", 1, Arrays.asList(new Item(ItemType.GRAIN), new Item(ItemType.LUMBER), new Item(ItemType.WOOL), new Item(ItemType.BRICK))),
	CITY("City", 2, Arrays.asList(new Item(ItemType.GRAIN), new Item(ItemType.ORE)));
	//PORT("Port", 0, null);

	private int value;
	private String label;
	private List<Item> cost;

	BuildingType(String label, int value, List<Item> cost) {
		this.label = label;
		this.value = value;
		this.cost = cost;
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