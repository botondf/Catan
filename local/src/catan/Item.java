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

//	public void addAmount(int amount) {
//		this.amount += amount;
//	}
//	
//	public int getAmount() {
//		return amount;
//	}

}