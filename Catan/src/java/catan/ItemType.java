package catan;

public enum ItemType {
	BRICK("Brick"), ORE("Ore"), WOOL("Wool"), LUMBER("Lumber"), GRAIN("Grain"), ROBBER("Robber");

	private String label;

	ItemType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}