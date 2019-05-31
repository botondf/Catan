package catangame;

import java.util.Arrays;
import java.util.List;

enum PlaceType {
	INTERSECTION(Arrays.asList(new Building(BuildingType.SETTLEMENT), new Building(BuildingType.CITY))),
	PATH(Arrays.asList(new Building(BuildingType.ROAD))),
	PORT(Arrays.asList(new Building(BuildingType.PORT)));
	
	
	private List<Building> possibleBuildings;
	
	PlaceType(List<Building> possibleBuildings) {
		this.possibleBuildings = possibleBuildings;
	}
}