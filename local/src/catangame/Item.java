package catangame;

import java.util.*; 

public class Item {
	ItemType type;
	int amount;
	
	Item (ItemType type, int amount) {
		this.type = type;
		this.amount = amount;
	}
	
	public void addAmount(int amount) {
		this.amount += amount;
	}
	

}