package catan;

import java.util.ArrayList;
import java.util.List;

public class GameInitialization {
	private List<PlayerGameInitialization> playerInits;

	public GameInitialization() {
		playerInits = new ArrayList<>(Main.NUM_PLAYERS);
		
		for (int i = 0; i < Main.NUM_PLAYERS; i++) {
			playerInits.add(new PlayerGameInitialization());
		}
	}
	
	PlayerGameInitialization getPlayerGameInitialization(int playerIndex) {
		return playerInits.get(playerIndex);
	}

	public List<PlayerGameInitialization> getPlayerInits() {
		return playerInits;
	}
	
}
