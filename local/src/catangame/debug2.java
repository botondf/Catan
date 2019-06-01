package catangame;

public class debug2 {
	public static void main(String[] args) {
		Player[] players = new Player[4];
		for (int x = 1; x <= players.length; x++) {
			players[x-1] = new Player(x);
		}
		
		Board board = new Board();
		System.out.println(board.toString() + "\n");
		int j = 11;
		Building b = new Building(BuildingType.SETTLEMENT, players[0], new Place());
		board.getTilesWithValue(j).get(0).addBuilding(b);
		//players[0].buildings.add(b);
		//board.getTilesWithValue(j).get(1).addBuilding(new Building(BuildingType.CITY, players[0], new Place()));
		System.out.println("Tile w value " + j + ": " + board.getTilesWithValue(j).toString());
		//Logic.rollDice();
		System.out.println(players[0].toString());
		//System.out.println("Roll: " + Logic.roll + ",  " + "Tile: "+ board.getTilesWithValue(Logic.roll).toString());
		
	}
}
