package catan;

public class Item {
	ItemType type;

	public Item(ItemType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Item [type=" + type + "]";
	}

	public ItemType getType() {
		return type;
	}

}