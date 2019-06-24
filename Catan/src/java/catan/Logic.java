package catan;

import java.util.List;

import catan.PlayerGameInitialization.Counter;
import javafx.scene.paint.Color;

/**
 * handle the turns and rolls - player increments, checks etc - and
 */
public class Logic {
	public int roll;
	public Player[] players = new Player[Catan.NUM_PLAYERS];
	private final int NUM_PLAYERS;
	private Player currentPlayer;
	public PlayerGameInitialization[] gameInit;
	public boolean initOver = false;
	public Counter initializeCounter = new Counter(2);

	public Logic(int NUM_PLAYERS) {
		this.NUM_PLAYERS = NUM_PLAYERS;
		for (int x = 0; x < this.NUM_PLAYERS; x++) {
			this.players[x] = new Player(x+1);	
		}
		
		players[0].setColor(Color.web("00a8f3")); // player 1 = blue 00a8f3
		players[1].setColor(Color.web("ec1c24")); // player 2 = red ec1c24
		
		initGame();
	}

	public int getRoll() {
		return roll;
	}

	public Player[] getPlayers() {
		return players;
	}

	/**
	 * generates random int from range a-b. order doesn't matter. to be used
	 * elsewhere too
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
	 * 
	 * @return roll as an int. range= 2-12.
	 */
	public void rollDice() {
		roll = randomNumber(1, 6) + randomNumber(1, 6);
	}

	/**
	 * Interprets the roll.
	 */
	public void handleRoll(Board board) {
		List<Tile> tiles = board.rollSelectedTiles;
		// Robber
		if (roll == 7) {
			tiles.get(1);
		} else if (roll != 7) {

		} else {
			throw new IllegalArgumentException("Something went wrong: Roll was (somehow) out of range");
		}
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void initGame() {
		initOver = false;
		
		// Player at 0 AKA player #1 is first player to make a move
		currentPlayer = players[0];
		
		gameInit = new PlayerGameInitialization[NUM_PLAYERS];
		
		
		for (Player p : players) {
			
			p.getBuildings().clear();
			p.getCards().clear();
			p.getItems().clear();
			p.setVp(0);
			
			gameInit[p.getId()-1] = new PlayerGameInitialization(p);
			PlayerGameInitialization gameInitTemp = gameInit[p.getId()-1];
			
			gameInitTemp.addInitBuildings();
			
			p.checkVP();
		}
	}

	public void nextPlayer() {
		Player previousPlayer = null;
		
		for (Player p : players) {
			if (p.getId() != currentPlayer.getId()) {
				previousPlayer = p;
			}
		}
		
		currentPlayer = previousPlayer;
	}
	/**
	 * For handling the next turn for the initialization
	 */
	public void nextTurn() {
		nextPlayer();
		
		if (initializeCounter.getCount() != 0) {
			initializeCounter.decrement();
		}
		
		if (initializeCounter.getCount() == 0) {
			initOver = true;
		}
		
	}

}