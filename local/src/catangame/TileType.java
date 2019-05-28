package catangame;

public enum TileType {
	HILLS("Hills", ItemType.BRICK), PASTURE("Pasture", ItemType.CATTLE), 
	FOREST("Forest", ItemType.LUMBER), MOUNTAIN("Mountain", ItemType.ORE),
	FIELDS("Fields", ItemType.GRAIN), DESERT("Desert", null);
	
	private ItemType resource;
	public String label;
	private ItemType type;
	
	TileType(String newLabel, ItemType newResource) {
		label = newLabel;
		type = newResource;
	}

}