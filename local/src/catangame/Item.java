package catangame;

import java.util.*; 

public class Item {
	ItemType type;
	int amount;
	
	enum ItemType {
		BRICK, CATTLE, WOOD, ORE, GRAIN, LUMBER
	}
	
	Item (ItemType type, int amount) {
		this.type = type;
		this.amount = amount;
	}
	
	Item() {
		
	}
	
	public void addAmount(int amount) {
		this.amount += amount;
	}
	
//	public List newItems() {
//		
//	}
}