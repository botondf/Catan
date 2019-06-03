package catangame;

import java.util.*;
import catangame.BuildingType.*;

public class Place {
	//array or list of neighbouring tiles
	Place neighbours;
	PlaceType placeType;
	//int[] coord = {x,y};
	
	Place(Place neighbours, PlaceType placeType) {
		this.neighbours = neighbours;
		this.placeType = placeType;
	}
	
	Place() {}
	
	public void findNeighbours() {
		
	}

	@Override
	public String toString() {
		return "Place [neighbours=" + neighbours + ", placeType=" + placeType + "]";
	}

		
//	public Place getPosition(Tile[] tiles) {
//		return new Place();
//	}
}
