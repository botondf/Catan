package catangame;

import java.util.*; 

public class Player {
	int id;
//	Item[] items;
	List<Item> itemsList;
	
	Player(int number) {
		this.id = number;
//		this.items = new Item[4]; // can only have max 4 items for now
		this.itemsList = new ArrayList<Item>();
		
	
	}
	
	public void addItems(Item item) {
//		items[0] = item;
		itemsList.add(item);
	}
	
	public void incrementItems(Item item, int increment) {
		item.amount += increment;
	}
}