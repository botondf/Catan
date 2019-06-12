package catan;

//import java.util.List;

public class Item {
	ItemType type;

	Item(ItemType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Item [type=" + type + "]";
	}

}