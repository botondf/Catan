package catan;

import java.util.Arrays;
import java.util.List;
import javafx.scene.paint.Color;

enum PlaceType {
	INTERSECTION(Arrays.asList(BuildingType.SETTLEMENT, BuildingType.CITY), Color.RED),
	PATH(Arrays.asList(BuildingType.ROAD), Color.BLUE);
	//PORT(Arrays.asList(BuildingType.PORT));

	private List<BuildingType> possibleBuildings;
	private Color color;

	PlaceType(List<BuildingType> possibleBuildings, Color color) {
		this.setPossibleBuildings(possibleBuildings);
		this.setColor(color);
	}

	private void setColor(Color color) {
		this.color = color;
	}

	public List<BuildingType> getPossibleBuildings() {
		return possibleBuildings;
	}

	public void setPossibleBuildings(List<BuildingType> possibleBuildings) {
		this.possibleBuildings = possibleBuildings;
	}
	
	
}