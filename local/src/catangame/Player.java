package catangame;

import java.util.*; 

public class Player {
	int id;
	int vp;
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
	
	@Override
	public String toString() {
		return "Player [id=" + id + ", vp=" + vp + ", items=" + items + ", cards=" + cards + ", buildings=" + buildings
				+ "]";
	}

	public void addItems(Item item) {
		items.add(item);
	}
	
	public void incrementItems(Item item, int increment) {
		item.amount += increment;
	}
}