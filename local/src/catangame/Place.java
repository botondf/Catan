package catangame;

import java.util.*;
import catangame.BuildingType.*;

public class Place {
	//array or list of neighbouring tiles
	Place neighbours;
	//int[] coord = {x,y};
	
	Place(Place neighbours) {
		this.neighbours = neighbours;
	}
	
	Place() {}
	
	public void findNeighbours() {
		
	}
	
//	public Place getPosition(Tile[] tiles) {
//		return new Place();
//	}
}
