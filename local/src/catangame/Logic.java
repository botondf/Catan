package catangame;


public class Logic {
	public static int roll;

	public static int randomNumber(int a, int b) {
	    int highNum = Math.max(a, b);
	    int lowNum = Math.min(a, b);
	    int range = highNum - lowNum + 1;
	    return (int) (Math.random() * range) + lowNum;
	}
	
	//handle rolls
	//randomize dice
	//
	
	
	/**
	 * Simulates rolling two d6 dies, then adding them together. 
	 * @return roll as an int. range= 2-12.
	 */
	public static void rollDice() {
		roll = randomNumber(1,6) + randomNumber(1,6);
	}
	/**
	 * Interprets the roll.
	 */
//	public void handleRoll() {
//		// Robber
//		if (roll == 7) {
//			Board.selectedTiles.add(Board.boardTiles[roll]);
//		} else if (roll >= 2 && roll < 7 && roll > 7 && roll <= 12) {
//			Board.selectedTiles.add(Board.boardTiles[roll]);
//		} else {
//			throw new IllegalArgumentException("Roll was (somehow) out of range");
//		}
//	}

}
