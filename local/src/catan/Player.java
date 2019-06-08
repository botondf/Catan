package catan;

import java.util.*; 

public class Player {
	private int id;
	private int vp;
	private List<Item> items;
	private List<Card> cards;
	private List<Building> buildings;
	
	Player(int id) {
		this.id = id;
		vp = 0;
		items = new ArrayList<Item>();
		cards = new ArrayList<Card>();
		buildings = new ArrayList<Building>();
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
			vp += b.getValue();
		}
		for (Card c : this.cards) {
			vp += c.getValue();
		}
	}
	
//	public void incrementItems(Item item, int increment) {
//		this.items.getAmount() += increment;
//	}

	public int getId() {
		return id;
	}

	public void setVP(int vp) {
		this.vp = vp;
	}

	public int getVp() {
		return vp;
	}

	public void setVp(int vp) {
		this.vp = vp;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public List<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}

	public void setId(int id) {
		this.id = id;
	}
}