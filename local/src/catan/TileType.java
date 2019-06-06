package catan;

import javafx.scene.paint.Color;

public enum TileType {
	HILL(Color.BROWN , ItemType.BRICK),
	PASTURE(Color.YELLOWGREEN , ItemType.WOOL), 
	FOREST(Color.DARKGREEN, ItemType.LUMBER),
	MOUNTAIN(Color.DARKGREY, ItemType.ORE),
	FIELD(Color.web("e5bf29"), ItemType.GRAIN),
	DESERT(Color.ANTIQUEWHITE, null);
	
	private Color color;
	private ItemType resource;
	
	TileType(Color color, ItemType resource) {
		this.color = color;
		this.resource = resource;
	}

	public ItemType getResource() {
		return resource;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

}