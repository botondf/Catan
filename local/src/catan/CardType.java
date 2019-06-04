package catan;

public enum CardType {	
	SOLDIER(1),
	LARGESTARMY(1),
	LONGESTROAD(2),
	UNIVERSITY(1);
	
	private int value;

	CardType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}