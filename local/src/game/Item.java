package game;

import java.util.*; 

public class Item {
	Type type;
	int amount;
	
	enum Type {
		WOOD, STONE, ORE
	}
	
	Item (Type type, int amount) {
		this.type = type;
		this.amount = amount;
	}
	
	public void addAmount(int amount) {
		this.amount += amount;
	}
	
//	public List newItems() {
//		
//	}
}