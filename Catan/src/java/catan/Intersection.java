package catan;

import java.util.ArrayList;
import java.util.List;

import catan.PlayerGameInitialization.Counter;
import javafx.scene.Node;
import simpleIO.Console;

public class Intersection extends Place {
	private List<Path> paths;
	// Type is village or city; it figures it out based on if buildings already exist at place
	private BuildingType typeToBuild = null; 

	Intersection(Point point) {
		super(PlaceType.INTERSECTION, point);
		paths = new ArrayList<>(3);
	}

	@Override
	public String toString() {
		return "Intersection [point=" + getPoint() + "]";
	}

	public void addPath(Path path) {
		if(paths.size() >= 3) {
			throw new IllegalStateException("One intersection can have up to 3 paths. " + 
					toString() + ", paths=" + paths + ", path=" + path);
		}
		paths.add(path);
	}

	public List<Path> getPaths() {
		return paths;
	}

	public List<Intersection> getNeighbours() {
		List<Intersection> neighbours = new ArrayList<>();
		
		paths.forEach(path -> neighbours.add(path.getB()));
		
		return neighbours;
	}
	
	@Override
	protected void handleClicked() {
		if (getBuilding() == null) {
			Player player = Catan.logic.getCurrentPlayer();

			PlayerGameInitialization gameInit = Catan.logic.gameInit[player.getId() - 1];
			Counter count = gameInit.buildingMap.get(typeToBuild = BuildingType.VILLAGE);

			if (count.getCount() != 0) {
				build(player, gameInit);
			}

			else if (count.getCount() == 0 && player.sufficientItemsCheck(typeToBuild)) {
				build(player, gameInit);
			} else {
				System.out.println("insufficient resources or out of inital buildings");
			}
		}
	}
	
	private void build(Player player, PlayerGameInitialization gameInit) {
		Building building = new Building(typeToBuild, player, this);
		if (gameInit.buildingMap.get(typeToBuild).getCount() == 0) {
			newBuildingType(building);
		}

		setBuilding(building);
		
		Node buildingNode = makeBuildingShape(player);
		
		
		setShape(buildingNode);
		
		gameInit.decrement(typeToBuild);
		
		player.getBuildings().remove(0);
	}

	/**
	 * @param building
	 * @return
	 */
	private void newBuildingType(Building building) {
		BuildingType newType;
		if(building != null) {
			if (building.getType() == BuildingType.VILLAGE) {
				newType = BuildingType.CITY;
			} else {
				System.out.println("cannot upgrade city");
				newType = null;
			} 
		} else {
			newType = BuildingType.VILLAGE;
		}
		typeToBuild = newType;
	}
}