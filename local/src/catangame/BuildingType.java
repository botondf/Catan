package catangame;

import java.util.*;

/**
 * 
 * Stores the <code> int </code> value of the building type (which is the resource gain multiplier, and the worth in VP's), the cost of each building type, and a <code> String </code> label
 *
 */


enum BuildingType {
	ROAD("Road", 0, Arrays.asList(ItemType.BRICK, ItemType.LUMBER)),
	SETTLEMENT("Settlement", 1, Arrays.asList(ItemType.GRAIN, ItemType.LUMBER, ItemType.CATTLE, ItemType.BRICK)),
	CITY("City", 2, Arrays.asList(ItemType.GRAIN, ItemType.GRAIN, ItemType.STONE, ItemType.STONE, ItemType.STONE)),
	HARBOUR("Harbour", 0, null);

	private final int value;
	private final String label;
	private final List<ItemType> cost;

	BuildingType(final String newLabel, final int newValue, final List<ItemType> cost) {
		label = newLabel;
		this.value = newValue;
		this.cost = cost;
	}

	public int getValue() {
		return value;
	}
}