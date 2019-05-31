package catangame;

import java.util.*;

/**
 * Stores the <code> int </code> value of the building type (which is the resource gain multiplier, and the worth in VP's), the cost of each building type, and a <code> String </code> label
 * Builds the random board.
 */

enum BuildingType {
	ROAD("Road", 0, Arrays.asList(new Item(ItemType.BRICK, 1), new Item(ItemType.LUMBER, 1))),
	SETTLEMENT("Settlement", 1, Arrays.asList(new Item(ItemType.GRAIN, 1), new Item(ItemType.LUMBER, 1), new Item(ItemType.WOOL, 1), new Item(ItemType.BRICK, 1))),
	CITY("City", 2, Arrays.asList(new Item (ItemType.GRAIN, 2), new Item(ItemType.ORE, 3))),
	PORT("Port", 0, null);

	private int value;
	private String label;
	private List<Item> cost;

	BuildingType(String newLabel, int newValue, List<Item> cost) {
		this.label = newLabel;
		this.value = newValue;
		this.cost = cost;
	}

	public int getValue() {
		return value;
	}
	
	public List<Item> getCost() {
		return this.cost;
	}
}