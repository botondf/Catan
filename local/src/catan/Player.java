package catan;

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
	
	public void addBuildingAtTile(Tile tileToBuildAt, Building newBuilding) {
		tileToBuildAt.getBuildings().add(newBuilding);
		this.buildings.add(newBuilding);
	}
	
	public void checkVP() {
		for (Building b : this.buildings) {
			this.vp += b.getValue();
		}
		for (Card c : this.cards) {
			this.vp += c.getValue();
		}
	}
	
	public void incrementItems(Item item, int increment) {
		item.amount += increment;
	}
}