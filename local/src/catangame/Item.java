package catangame;

import java.util.*; 

public class Item {
	Type type;
	int amount;
	
	enum Type {
		ONE, TWO, THREE
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