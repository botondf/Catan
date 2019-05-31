package catangame;

public enum TileType {
	HILL("Hill", ItemType.BRICK),
	PASTURE("Pasture", ItemType.WOOL), 
	FOREST("Forest", ItemType.LUMBER),
	MOUNTAIN("Mountain", ItemType.ORE),
	FIELD("Field", ItemType.GRAIN),
	DESERT("Desert", null);
//	WATER(null, null),
//	HARBOUR("Harbour", null);
	
	private ItemType resource;
	private String label;
	
	TileType(String label, ItemType resource) {
		this.label = label;
		this.resource = resource;
	}

	public ItemType getResource() {
		return resource;
	}
	
	public String getLabel() {
		return label;
	}

}