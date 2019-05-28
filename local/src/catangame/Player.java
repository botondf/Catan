package catangame;

import java.util.*; 

public class Player {
	int id;
	int vp;
	//List[] possesions; // all of player's possessions in an array (might be redundant)
	List<Item> itemsList;
	List<Card> cardList;
	List<Building> buildingsList;
	
	Player(int id) {
		this.id = id;
		this.vp = 0;
		this.itemsList = new ArrayList<Item>();
		this.cardList = new ArrayList<Card>();
		this.buildingsList = new ArrayList<Building>();
	}
	
	public void addItems(Item item) {
//		items[0] = item;
		itemsList.add(item);
	}
	
	public void incrementItems(Item item, int increment) {
		item.amount += increment;
	}
}