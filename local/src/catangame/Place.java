package catangame;

public class Place {
	//array or list of neighbouring tiles
	Place neighbours;
	//int[] coord = {x,y};
	
	Place(Place neighbours) {
		this.neighbours = neighbours;
	}
	
	public void findNeighbours() {
		
	}
	
	public Place getPosition(Tile[] tiles) {
		return new Place();
	}
}
