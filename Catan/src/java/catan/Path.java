package catan;

import catan.PlayerGameInitialization.Counter;
import javafx.scene.Node;

public class Path extends Place {
	private BuildingType typeToBuild = BuildingType.ROAD;
	private Intersection a;
	private Intersection b;

	public Path(Point point, Intersection a, Intersection b) {
		super(PlaceType.PATH, point);
		if (a == null) {
			throw new IllegalArgumentException("intersection A missing");
		}
		if (b == null) {
			throw new IllegalArgumentException("intersection B missing");
		}
		this.a = a;
		this.b = b;

		a.addPath(this);
		b.addPath(this);
	}

	@Override
	public String toString() {
		return "Path [a=" + a + ", b=" + b + ", centre=" + getPoint() + "]";
	}
	
	@Override
	protected void handleClicked() {

		if (getBuilding() == null) {
			Player player = Catan.logic.getCurrentPlayer();

			PlayerGameInitialization gameInit = Catan.logic.gameInit[player.getId() - 1];
			Counter count = gameInit.buildingMap.get(typeToBuild);
			
			Building building = new Building(typeToBuild, player, this);


			if (count.getCount() != 0) {
				build(building, player, gameInit);

			} else if (count.getCount() == 0 && player.sufficientItemsCheck(typeToBuild)) {
				
				build(building, player, gameInit);
				
				player.addBuilding(building);

			} else {
				System.out.println("insufficient resources or out of inital buildings");
			}
		}
	}
	
	private void build(Building building, Player player, PlayerGameInitialization gameInit) {

		setBuilding(building);
		
		Node buildingNode = makeBuildingShape(player);
		
		setShape(buildingNode);
		
		gameInit.decrement(typeToBuild);
		
		player.getBuildings().remove(0);
	}
	
	public Intersection getA() {
		return a;
	}

	public Intersection getB() {
		return b;
	}
}