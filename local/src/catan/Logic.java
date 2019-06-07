package catan;

import java.util.ArrayList;
import java.util.List;

/**
 * handle the turns and rolls - player increments, checks etc - and 
 */
public class Logic {
	public int roll;

	/**
	 * generates random int from range a-b. order doesn't matter. to be used elsewhere too
	 * @param a range1
	 * @param b range2
	 * @return random int
	 */
	public static int randomNumber(int a, int b) {
	    int highNum = Math.max(a, b);
	    int lowNum = Math.min(a, b);
	    int range = highNum - lowNum + 1;
	    return (int) (Math.random() * range) + lowNum;
	}
	
	
	/**
	 * Simulates rolling two d6 dies, then adding them together. 
	 * @return roll as an int. range= 2-12.
	 */
	public void rollDice() {
		roll = randomNumber(1,6) + randomNumber(1,6);
	}
	/**
	 * Interprets the roll.
	 */
	public void handleRoll(Board board) {
		 List<Tile> tiles = board.getTilesWithValue(roll);
		// Robber
		if (roll == 7) {
			tiles.get(1);
		} else if (roll != 7) {
			
		} else {
			throw new IllegalArgumentException("Something went wrong: Roll was (somehow) out of range");
		}
	}

}
