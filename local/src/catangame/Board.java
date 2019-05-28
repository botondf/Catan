package catangame;

import catangame.Tile.*;

public class Board {
	Tile[] tiles = new Tile[12];
	//Player[] players;
	
	Board() {
		//tiles[0] = Tile(0, TileType.HILLS, 11, {});
		// Generate new random board
				//	Create Tile
				//		Set values to Tile
				//		*Determine (X,Y) co-ords of each tile for drawing
	}
	
	public static int randomNumber(int a, int b) {
	    int highNum = Math.max(a, b);
	    int lowNum = Math.min(a, b);
	    int range = highNum - lowNum + 1;
	    return (int) (Math.random() * range) + lowNum;
	}
	
}