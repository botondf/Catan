package catan;

import java.util.ArrayList;
import java.util.List;

public class Intersection extends Place {
	private List<Path> paths;
	private List<Tile> tiles;
	private Point point;

	Intersection(Point point) {
		super(PlaceType.INTERSECTION);
		this.point = point;
		tiles = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Intersection [point=" + point + "]"; //paths=" + paths + ", 
	}

	public List<Path> getPaths() {
		return paths;
	}

	public void addNeighbour(Intersection intersection) {
		Path path = new Path(this, intersection);
		paths.add(path);
	}
	
	public List<Intersection> getNeighbours() {
		List<Intersection> neighbours = new ArrayList<>();
		
		paths.forEach(path -> neighbours.add(path.getB()));
		
		return neighbours;
	}

	public Point getPoint() {
		return point;
	}

	public void addTile(Tile tile) {
		tiles.add(tile);		
	}

	public List<Tile> getTiles() {
		return tiles;
	}
}