package catangame;

import java.util.*;

//import catangame.Item.Type;

public class Debug {

	public static void main(String[] args) {
//		Player p1 = new Player(1);
//		Player p2 = new Player(2);
//		
//		p1.addItems(new Item(Type.ONE, 0));
//		p1.addItems(new Item(Type.TWO, 1));
//		p1.addItems(new Item(Type.THREE, 2));
//		p2.addItems(new Item(Type.ONE, 0));
//		p2.addItems(new Item(Type.TWO, 1));
//		p2.addItems(new Item(Type.THREE, 2));

//		for (int p = 1; p < 5; p++) {
//			Player player = new Player(p);
//			player.addItems(new Item(Type.WOOD, 1));
//			player.addItems(new Item(Type.STONE, 1));
//			player.addItems(new Item(Type.ORE, 2));
//			System.out.println("Player " + player.number + ": ");
//			for (int x = 0; x < 3; x++) {
//				for (int z = 0; z < 3; z++) {
//					player.incrementItems(player.itemsList.get(z), 13);
//				}
//				System.out.println(player.itemsList.get(x).type + ", " + player.itemsList.get(x).amount);
//			}
//			System.out.println("");
//		}

//		p1.incrementItems(p1.itemsList.get(0), 50);	// add 50 wood
//		System.out.println(p1.itemsList.get(0).type + ", " + p1.itemsList.get(0).amount);
//		System.out.println(p2.itemsList.get(1).type + ", " + p2.itemsList.get(1).amount);
//
//	    p1.incrementItems(p1.itemsList.get(0), 10);	// add 10 wood
//	    System.out.println(p1.itemsList.get(0).type + ", " + p1.itemsList.get(0).amount);
//	    System.out.println(p2.itemsList.get(1).type + ", " + p2.itemsList.get(1).amount);
		
		while (true) {
			Building.debugCreateRandom().print();
		}
		
		

	}

}