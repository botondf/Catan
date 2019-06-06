package catan;

public class Debug {
	public static void main(String[] args) {
		Player[] players = new Player[4];
		for (int x = 1; x <= players.length; x++) {
			players[x-1] = new Player(x);
		}
		
		Board board = new Board();
		System.out.println(board.toString() + "\n");
		int j = Logic.randomNumber(1, 6) + Logic.randomNumber(1, 6);
		Building b = new Building(BuildingType.SETTLEMENT, players[0], new Place());
		Building b2 = new Building(BuildingType.CITY, players[0], new Place());
		players[0].addBuildingAtTile(board.getTilesWithValue(j).get(0), b);
		players[0].addBuildingAtTile(board.getTilesWithValue(j).get(0), b2);

		//players[0].buildings.add(b);
		//board.getTilesWithValue(j).get(1).addBuilding(new Building(BuildingType.CITY, players[0], new Place()));
		System.out.println("Tile w value " + j + ": " + board.getTilesWithValue(j).toString());
		//Logic.rollDice();
		players[0].checkVP();
		System.out.println(players[0].toString());
		//System.out.println("Roll: " + Logic.roll + ",  " + "Tile: "+ board.getTilesWithValue(Logic.roll).toString());
		
	}
	
	public static void init() {
		Player[] players = new Player[4];
		for (int x = 1; x <= players.length; x++) {
			players[x-1] = new Player(x);
		}
		
		Board board = new Board();
		
		int j = Logic.randomNumber(1, 6) + Logic.randomNumber(1, 6);
		Building b = new Building(BuildingType.SETTLEMENT, players[0], new Place());
		Building b2 = new Building(BuildingType.CITY, players[0], new Place());
		
		players[0].addBuildingAtTile(board.getTilesWithValue(j).get(0), b);
		players[0].addBuildingAtTile(board.getTilesWithValue(j).get(0), b2);
		players[0].checkVP();
		board.draw();
	}
}
