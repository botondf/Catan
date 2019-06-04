package catan;
/**
 * 
 * The different cards that can be bought throughout the game. Have an affect on Player (vp's, resources) and Board (robber location), Bank (draw resources), Building (build roads)
 *
 */
public class Card {
	int value;
	private CardType type;
	
	
	
	Card(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Card [value=" + value + "]";
	}
	
	
}
