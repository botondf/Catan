package catangame;

import java.util.*; 

public class Player {
	int id;
	int vp;
	//List[] possesions; // all of player's possessions in an array (might be redundant)
	List<Item> items;
	List<Card> cards;
	List<Building> buildings;
	
	Player(int id) {
		this.id = id;
		this.vp = 0;
		this.items = new ArrayList<Item>();
		this.cards = new ArrayList<Card>();
		this.buildings = new ArrayList<Building>();
	}
	
	public void addItems(Item item) {
//		items[0] = item;
		items.add(item);
	}
	
	public void incrementItems(Item item, int increment) {
		item.amount += increment;
	}
}