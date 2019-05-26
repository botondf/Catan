package game;

import game.Item.Type;

public class PlayerDebug {

	public static void main(String[] args) {
		//Player p1 = new Player(1);
		//Player p2 = new Player(2);
		
//		p1.addItems(new Item(Types.WOOD, 0));
//		p1.addItems(new Item(Types.STONE, 1));
//		p1.addItems(new Item(Types.ORE, 2));
//		p2.addItems(new Item(Types.WOOD, 0));
//		p2.addItems(new Item(Types.STONE, 1));
//		p2.addItems(new Item(Types.ORE, 2));

		for (int p = 1; p < 5; p++) {
			Player player = new Player(p);
			player.addItems(new Item(Type.WOOD, 1));
			player.addItems(new Item(Type.STONE, 1));
			player.addItems(new Item(Type.ORE, 2));
			System.out.println("Player " + player.number + ": ");
			for (int x = 0; x < 3; x++) {
				for (int z = 0; z < 3; z++) {
					player.incrementItems(player.itemsList.get(z), 13);
				}
				System.out.println(player.itemsList.get(x).type + ", " + player.itemsList.get(x).amount);
			}
			System.out.println("");
		}

//		p1.incrementItems(p1.itemsList.get(0), 50);	// add 50 wood
//
//	    p1.incrementItems(p1.itemsList.get(0), 10);	// add 10 wood
 
	}

}

